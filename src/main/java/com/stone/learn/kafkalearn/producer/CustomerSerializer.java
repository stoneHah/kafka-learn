package com.stone.learn.kafkalearn.producer;

import org.apache.kafka.common.serialization.Serializer;

import java.nio.ByteBuffer;
import java.util.Map;

public class CustomerSerializer implements Serializer<Customer> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String topic, Customer data) {
        if (data == null) {
            return null;
        }

        byte[] serializedName;
        int serializedLength;

        if (data != null) {
            serializedName = data.getName().getBytes();
            serializedLength = serializedName.length;

        }else {
            serializedName = new byte[0];
            serializedLength = 0;
        }

        ByteBuffer buffer = ByteBuffer.allocate(4 + 4 + serializedLength);
        buffer.putInt(data.getId());
        buffer.putInt(serializedLength);
        buffer.put(serializedName);

        return buffer.array();
    }

    @Override
    public void close() {

    }
}
