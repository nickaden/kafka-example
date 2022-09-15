package by.nick.kafka.consumer;

import by.nick.kafka.Vehicle;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public void updateVehicle(Vehicle vehicle) {
        double distance = vehicleRepository.findById(vehicle.getId())
                .map(entry ->  calculateDistance(vehicle, entry))
                .orElse(0.0);
        log.info("Current vehicle (id={}) is on {}/{}. Went distance: {} meters", vehicle.getId(), vehicle.getLatitude(),
                vehicle.getLongitude(), distance );
        vehicleRepository.save(vehicle);
    }

    private double calculateDistance(Vehicle newEntry, Vehicle oldEntry) {
        final int R = 6371; // Radius of the earth

        var latDistance  =  Math.toRadians(newEntry.getLatitude() - oldEntry.getLatitude());
        var lonDistance  = Math.toRadians(newEntry.getLongitude() - oldEntry.getLongitude());
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(newEntry.getLatitude())) * Math.cos(Math.toRadians(oldEntry.getLatitude()))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c * 1000; // convert to meters
    }
}
