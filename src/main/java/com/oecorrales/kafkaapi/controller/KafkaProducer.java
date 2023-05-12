package com.oecorrales.kafkaapi.controller;

import com.oecorrales.kafkaapi.service.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.oecorrales.kafkaapi.enums.kafka.kafkaTopic;

@RestController
@RequestMapping("/api/v1/producer")
public class KafkaProducer {

    @Autowired
    KafkaSender kafkaSender;
    String returnMessage;
    HttpStatus statusCode;

    kafkaTopic kafkaTopic;

    @PostMapping
    public ResponseEntity<String> producer(@RequestParam("message") String message) {
        kafkaSender.send(message);

        String returnMessage = "Message sent to the Kafka Topic " + kafkaTopic.FIRST_TOPIC + " Successful";

        return new ResponseEntity<>(returnMessage, HttpStatus.OK);
    }

    @PostMapping("/{topic}")
    public ResponseEntity<String> produceToTopic(@PathVariable String topic, @RequestParam("message") String message) {
        if (kafkaTopic.isTopic(topic)) {
            kafkaSender.sendToTopic(topic, message);

            returnMessage = "Message sent to the Kafka Topic " + topic + " Successful";
            statusCode = HttpStatus.OK;

        } else {
            returnMessage = "There was an error finding the topic:" + topic;
            statusCode = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(returnMessage, statusCode);
    }
}
