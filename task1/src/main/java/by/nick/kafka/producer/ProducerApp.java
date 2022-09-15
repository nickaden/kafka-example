package by.nick.kafka.producer;

import by.nick.kafka.infra.KafkaInfraBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@Import(KafkaInfraBuilder.class)
public class ProducerApp {

    public static void main(String[] args) {
        System.setProperty("server.port", "8082");
        SpringApplication.run(ProducerApp.class);
    }
}
