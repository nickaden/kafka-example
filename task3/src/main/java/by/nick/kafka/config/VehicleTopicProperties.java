package by.nick.kafka.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "app.kafka.topic")
public class VehicleTopicProperties {

    private String name;
    private Integer partitions;
    private Short replications;
}
