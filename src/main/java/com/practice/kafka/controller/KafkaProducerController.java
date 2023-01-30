package com.practice.kafka.controller;

import com.practice.kafka.producer.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaProducerController {

    private final KafkaProducer kafkaProducer;

    public KafkaProducerController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody String message){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to kafka topic");
    }
}