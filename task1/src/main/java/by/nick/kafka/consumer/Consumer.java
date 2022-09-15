package by.nick.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class Consumer {

    @KafkaListener(topics = "${app.kafka.topic.name}", groupId = "${app.kafka.consumer.group.id}")
    public void listenTopic(@Payload List<String> messages, Acknowledgment acknowledgment) {
        // Acknowledge before processing - can cause data loss
        acknowledgment.acknowledge();
        // Processing
        messages.forEach(message -> log.info("Message received: {}", message));
    }
}
