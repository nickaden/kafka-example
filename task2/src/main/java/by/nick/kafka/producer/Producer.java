package by.nick.kafka.producer;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
@RequiredArgsConstructor
@Slf4j
public class Producer {

    @Value(value = "${app.kafka.topic.name}")
    private String topicName;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Transactional
    public void send(String message) {
        var future = kafkaTemplate.send(topicName, message);

        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(@NonNull Throwable exception) {
                log.error("Unable to send message", exception);
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("Message sent: {}", result.getRecordMetadata().toString());
            }
        });
    }
}
