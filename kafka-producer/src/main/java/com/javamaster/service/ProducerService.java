package com.javamaster.service;

import com.javamaster.entity.Electronic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    @Autowired
    private KafkaTemplate<String, Electronic> kafkaTemplate;

    public void produce(Electronic electronic) {
        kafkaTemplate.send("electronics", electronic);
    }
}
