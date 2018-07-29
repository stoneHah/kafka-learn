package com.stone.learn.kafkalearn.producer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConsumerTest {
    private static final Logger logger = LoggerFactory.getLogger(ConsumerTest.class);

    public static void main(String[] args) {
        Properties kafkaProp = new Properties();
        kafkaProp.put("bootstrap.servers", "localhost:9092");
        kafkaProp.put("group.id", "CountryCounter");
        kafkaProp.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        kafkaProp.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        kafkaProp.put("metrics.log.level", "ERROR");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(kafkaProp);

        consumer.subscribe(Collections.singletonList("CustomerCountry"));

        Map<String, Integer> custCountryMap = new HashMap<>();
        try {
            while (true) {
                ConsumerRecords<String, String> consumerRecords = consumer.poll(100);
                for (ConsumerRecord<String, String> record : consumerRecords) {
                    logger.info("topic={},partition={},offset={},consumer={},country={}",
                            record.topic(),record.partition(),record.offset(),record.key(),record.value());

                    int updateCount = 1;
                    if(custCountryMap.containsKey(record.value())){
                        updateCount = custCountryMap.get(record.value());
                    }

                    custCountryMap.put(record.value(), updateCount);

                    System.out.println(custCountryMap);
                }
            }
        } finally {
            consumer.close();
        }
    }
}
