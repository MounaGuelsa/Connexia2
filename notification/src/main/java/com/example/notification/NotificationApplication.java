package com.example.notification;

import com.example.notification.dto.groupevent;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class NotificationApplication {

	private final ObservationRegistry observationRegistry;

    public static void main(String[] args) {
		SpringApplication.run(NotificationApplication.class, args);
	}

	@KafkaListener(topics = "notificationTopic")
	public void handleNotification(groupevent gpevent) {
		Observation.createNotStarted("on-message", this.observationRegistry).observe(() -> {
			log.info("Got message <{}>", gpevent);
			log.info("Received Notification for group - {}",gpevent.getGroupId());
		});
		// send out an email notification
	}
}
