package org.example.group.listener;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.group.event.groupevent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Component
@Slf4j
public class GroupEventListener {
    private final KafkaTemplate<String, groupevent> kafkaTemplate;
    private final ObservationRegistry observationRegistry;

    public GroupEventListener(KafkaTemplate<String, groupevent> kafkaTemplate, ObservationRegistry observationRegistry) {
        this.kafkaTemplate = kafkaTemplate;
        this.observationRegistry = observationRegistry;
    }

    @EventListener
    public void handleOrderPlacedEvent(groupevent event) {
        log.info("group Event Received, Sending groupid to notificationTopic: {}", event.getGroupId());

        // Create Observation for Kafka Template
        try {
            Observation.createNotStarted("notification-topic", this.observationRegistry).observeChecked(() -> {
                CompletableFuture<SendResult<String, groupevent>> future = kafkaTemplate.send("notificationTopic",
                        new groupevent(event.getGroupId()));
                return future.handle((result, throwable) -> CompletableFuture.completedFuture(result));
            }).get();
        } catch (InterruptedException  | ExecutionException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Error while sending message to Kafka", e);
        }
    }
}
