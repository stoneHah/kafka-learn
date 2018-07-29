package com.stone.learn.kafkalearn;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaLearnApplicationTests {

	@Autowired
	private KafkaTemplate kafkaTemplate;

	@Autowired
	private KafkaAdmin kafkaAdmin;



	@Test
	public void contextLoads() {
	}

	@Test
	public void testCreateTopic(){
//		kafkaTemplate.
		NewTopic newTopic = new NewTopic("noval", 1, (short) 1);

		AdminClient adminClient = AdminClient.create(kafkaAdmin.getConfig());
		List<NewTopic> topicList = Arrays.asList(newTopic);
		adminClient.createTopics(topicList);

		adminClient.close(10,TimeUnit.SECONDS);

	}

}
