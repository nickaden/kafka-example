package by.nick.kafka.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class ConsumerTransactionalApp {

    public static void main(String[] args) {
        System.setProperty("server.port", "8081");
        SpringApplication.run(ConsumerTransactionalApp.class);
    }
}
