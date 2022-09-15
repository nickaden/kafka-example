package by.nick.kafka.producer;

import by.nick.kafka.Vehicle;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TaxiController {
    private final VehicleProducer vehicleProducer;

    @PostMapping("/vehicles/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateVehicleInfo(@RequestBody Vehicle vehicle, @PathVariable Integer id)
            throws JsonProcessingException {
        vehicle.setId(id);
        vehicleProducer.produceVehicleEvent(vehicle);
    }
}
