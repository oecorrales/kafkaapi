package com.oecorrales.kafkaapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.oecorrales.kafkaapi.enums.kafka.kafkaTopic;

@Service
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    kafkaTopic kafkaTopic;

    public void send(String message) {
        kafkaTemplate.send(String.valueOf(kafkaTopic.FIRST_TOPIC), message);
    }

    public void sendToTopic(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }
}
