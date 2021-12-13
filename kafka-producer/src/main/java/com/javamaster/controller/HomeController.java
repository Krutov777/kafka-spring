package com.javamaster.controller;

import com.javamaster.entity.Electronic;
import com.javamaster.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @Autowired
    private ProducerService producerService;

    @PostMapping("electronic")
    public String generateElectronic(@RequestBody Electronic electronic) {
        producerService.produce(electronic);
        return "Electronic created!";
    }
}
