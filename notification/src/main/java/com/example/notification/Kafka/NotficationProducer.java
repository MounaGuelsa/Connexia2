package com.example.notification.Kafka;

import com.example.basedomain.Dto.NotificationEvent;
import org.apache.kafka.clients.admin.NewTopic;

import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class NotficationProducer {
    private NewTopic topic;
    private static final Logger logger = (Logger) LoggerFactory.getLogger(NotficationProducer.class);
    private KafkaTemplate<String, NotificationEvent> kafkaTemplate;
    public NotficationProducer(NewTopic topic, KafkaTemplate<String, NotificationEvent> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendNotification(NotificationEvent notificationEvent) {
        kafkaTemplate.send(topic.name(), notificationEvent);
        logger.info(String.format("Produced notification -> %s", notificationEvent));
        Message<NotificationEvent> message  =MessageBuilder.withPayload(notificationEvent)
                .setHeader(KafkaHeaders.TOPIC, topic.name())
                .build();
        kafkaTemplate.send(message);
    }

}
