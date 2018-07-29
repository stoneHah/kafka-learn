package com.stone.learn.kafkalearn.producer;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;

public class ProducerTest {
    public static void main(String[] args) {
        Properties kafkaProp = new Properties();
        kafkaProp.put("bootstrap.servers", "localhost:9092");
        kafkaProp.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        kafkaProp.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(kafkaProp);

        ProducerRecord<String, String> record = new ProducerRecord<>("CustomerCountry", "Precision Products", "France");
        try {
            kafkaProducer.send(record);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*ProducerRecord<String, String> record = new ProducerRecord<>("CustomerCountry", "Hello kafka", "USA");
        kafkaProducer.send(record, new Callback() {
            @Override
            public void onCompletion(RecordMetadata metadata, Exception exception) {

            }
        });*/

        try {
            Thread.sleep(5000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
