package ru.rnikonorov.kafkademo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import ru.rnikonorov.kafkademo.config.KafkaConfiguration;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaConfiguration kafkaConfiguration;

    public void sendMessage(String msg) {
        kafkaTemplate.send(kafkaConfiguration.topic1().name(), msg);
    }

    @KafkaListener(topics = "${kafka.topic1Name}", groupId = "${kafka.groupId}")
    public void listenGroupFoo(String message) {
        log.info("Received Message: " + message);
    }

}
