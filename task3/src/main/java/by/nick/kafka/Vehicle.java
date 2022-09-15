package by.nick.kafka;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name="vehicle", schema = "taxi")
public class Vehicle {

    @Id
    private Integer id;
    private String vendor;
    private Double latitude;
    private Double longitude;
}
