package com.example.rabbitmqdemo.controller;

import com.example.rabbitmqdemo.publisher.TestPublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @Autowired
    TestPublisher testPublisher;

    @GetMapping("aa")
    public boolean publish(String exchange, String routingKey, String message) {
        return testPublisher.publishMessage(exchange, routingKey, message);
    }
}
