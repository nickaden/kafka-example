package by.nick.kafka.infra;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class KafkaInfraBuilder {

    @Value("${app.kafka.topic.name}")
    private String topicName;
    @Value("${app.kafka.topic.partitions}")
    private Integer topicPartitions;
    @Value("${app.kafka.topic.replication}")
    private Integer replicationFactor;

    private final KafkaAdmin kafkaAdmin;

    @PostConstruct
    public void buildInfra() {
        NewTopic topic = new NewTopic(topicName, topicPartitions, replicationFactor.shortValue());
        kafkaAdmin.createOrModifyTopics(topic);
    }
}
