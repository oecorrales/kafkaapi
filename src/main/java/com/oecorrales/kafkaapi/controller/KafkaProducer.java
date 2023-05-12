package com.oecorrales.kafkaapi.controller;

import com.oecorrales.kafkaapi.service.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/producer")
public class KafkaProducer {

    @Autowired
    KafkaSender kafkaSender;

    @Value("${FIRST_TOPIC}")
    String firstTopic;

    @PostMapping
    public ResponseEntity<String> producer(@RequestParam("message") String message) {
        kafkaSender.send(message);

        String returnMessage = "Message sent to the Kafka Topic " + firstTopic + " Successful";

        return new ResponseEntity<>(returnMessage, HttpStatus.OK);
    }

    @PostMapping("/{topic}")
    public ResponseEntity<String> produceToTopic(@PathVariable String topic, @RequestParam("message") String message) {
        kafkaSender.sendToTopic(topic, message);

        String returnMessage = "Message sent to the Kafka Topic " + topic + " Successful";

        return new ResponseEntity<>(returnMessage, HttpStatus.OK);
    }
}
