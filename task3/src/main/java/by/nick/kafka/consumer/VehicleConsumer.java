package by.nick.kafka.consumer;

import by.nick.kafka.Vehicle;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VehicleConsumer {

    private final ObjectMapper objectMapper;
    private final VehicleService vehicleService;

    @KafkaListener(topics = "${app.kafka.topic.name}", groupId = "${app.kafka.consumer.groupId}")
    public void doOnReceive(String message) {
        try {
            Vehicle vehicle = objectMapper.readValue(message, Vehicle.class);
            vehicleService.updateVehicle(vehicle);

        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
