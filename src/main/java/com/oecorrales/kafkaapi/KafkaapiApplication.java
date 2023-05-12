package com.oecorrales.kafkaapi;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

@SpringBootApplication
public class KafkaapiApplication {

	@Value("${kafka.first.topic}")
	String firstTopic;

	public static void main(String[] args) {
		SpringApplication.run(KafkaapiApplication.class, args);
	}

	@Bean
	public NewTopic topic() {
		return TopicBuilder.name(firstTopic)
				.partitions(10)
				.replicas(1)
				.build();
	}
}
