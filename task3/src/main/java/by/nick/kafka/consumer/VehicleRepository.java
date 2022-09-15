package by.nick.kafka.consumer;

import by.nick.kafka.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {


}
