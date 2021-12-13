package com.javamaster.service;


import com.javamaster.entity.Electronic;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class ConsumerService {

    private final ElectronicService electronicService;

    public ConsumerService(ElectronicService electronicService) {
        this.electronicService = electronicService;
    }

    @KafkaListener(topics = "electronics", groupId = "electronic_group_id${server.port}")
    public void consumeElectronic(Electronic electronic){
        System.out.println("Consuming the message: \n" + electronic.toString());
        electronicService.addElectronic(electronic);
    }

}