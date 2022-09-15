package by.nick.kafka.infra;

import by.nick.kafka.config.VehicleTopicProperties;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class KafkaInfraBuilder {

    private final KafkaAdmin kafkaAdmin;
    private final VehicleTopicProperties topicProperties;

    @PostConstruct
    public void setUpTopic() {
        NewTopic topic = new NewTopic(topicProperties.getName(), topicProperties.getPartitions(),
                topicProperties.getReplications());
        kafkaAdmin.createOrModifyTopics(topic);
    }
}
