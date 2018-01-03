package com.example.rabbitmqdemo.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TestListener {
    static final Logger LOGGER = LoggerFactory.getLogger(TestListener.class);

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = "aa", durable = "true"),
                    exchange = @Exchange(value = "catalogExchange", type = "topic", durable = "true"),
                    key = "editCatalogKey")
    )
    public void receiveMessage(Message message) throws Exception {
        log(message);
    }

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = "bb", durable = "true"),
                    exchange = @Exchange(value = "catalogExchange", type = "topic", durable = "true"),
                    key = "editCatalogKey")
    )
    public void receiveMessage1(Message message) throws Exception {
        log(message);
    }

    public void log(Message message) {
        LOGGER.info("exchange {} ", message.getMessageProperties().getReceivedExchange());
        LOGGER.info("routing {} ", message.getMessageProperties().getReceivedRoutingKey());
        LOGGER.info("queue {} ", message.getMessageProperties().getConsumerQueue());
        LOGGER.info("body {} ", new String(message.getBody()));
        LOGGER.info("message {} ", message);
    }
}
