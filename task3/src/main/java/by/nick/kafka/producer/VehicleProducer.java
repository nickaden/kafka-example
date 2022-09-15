package by.nick.kafka.producer;

import by.nick.kafka.Vehicle;
import by.nick.kafka.config.VehicleTopicProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehicleProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;
    private final VehicleTopicProperties topicProperties;

    public void produceVehicleEvent(Vehicle vehicle) throws JsonProcessingException {
        kafkaTemplate.send(topicProperties.getName(), Integer.toString(vehicle.getId()),
                objectMapper.writeValueAsString(vehicle));
    }
}
