package com.stone.learn.kafkalearn.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SpringOperatorTest {

    @Autowired
    private KafkaTemplate kafkaTemplate;
}
