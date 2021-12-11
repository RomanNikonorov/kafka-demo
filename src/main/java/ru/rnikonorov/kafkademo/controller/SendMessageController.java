package ru.rnikonorov.kafkademo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.rnikonorov.kafkademo.service.KafkaService;

@RestController
@RequiredArgsConstructor
public class SendMessageController {
    private final KafkaService kafkaService;

    @GetMapping("/send")
    public ResponseEntity<String> sendMessage(final String msg) {
        kafkaService.sendMessage(msg);
        return ResponseEntity.ok("");
    }
}
