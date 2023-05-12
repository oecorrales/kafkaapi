package com.oecorrales.kafkaapi.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MyKafkaListener {
    @Value("${kafka.first.topic}")
    String firstTopic;

    @KafkaListener(id = "myId", topics = "kafkaTest")
    public void listen(String in) {
        System.out.println("Mensaje Recibido en Kafka" + in);
    }
}
