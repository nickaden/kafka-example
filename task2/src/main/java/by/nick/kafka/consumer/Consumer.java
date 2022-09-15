package by.nick.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class Consumer {

    @KafkaListener(topics = "${app.kafka.topic.name}", groupId = "${app.kafka.consumer.group.id}")
    public void listenTopic(List<String> messages) {
        // Processing
        messages.forEach(message -> log.info("Message received: {}", message));
    }
}
