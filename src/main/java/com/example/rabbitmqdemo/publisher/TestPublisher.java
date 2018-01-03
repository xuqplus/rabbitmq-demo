package com.example.rabbitmqdemo.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestPublisher {
    static final Logger LOGGER = LoggerFactory.getLogger(TestPublisher.class);

    @Autowired
    RabbitTemplate rabbitTemplate;

    public boolean publishMessage(String exchange, String routingKey, String message) {
        try {
            rabbitTemplate.convertAndSend(exchange, routingKey, message);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}