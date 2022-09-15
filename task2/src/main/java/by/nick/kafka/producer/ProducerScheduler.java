package by.nick.kafka.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class ProducerScheduler {

    private final Producer producer;

    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.SECONDS)
    public void setSchedule() {
        producer.send("Now is " + LocalTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME));
    }
}
