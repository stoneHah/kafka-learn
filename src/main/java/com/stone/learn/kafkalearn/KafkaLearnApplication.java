package com.stone.learn.kafkalearn;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class KafkaLearnApplication {

	@Bean
	public KafkaAdmin admin() {
		Map<String, Object> configs = new HashMap<>();
		configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,
				"localhost:9092");
		return new KafkaAdmin(configs);
	}

	public static void main(String[] args) {
		SpringApplication.run(KafkaLearnApplication.class, args);
	}
}
