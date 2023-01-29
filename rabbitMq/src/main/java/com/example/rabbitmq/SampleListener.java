package com.example.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SampleListener {

    private static final Logger log = LoggerFactory.getLogger(SampleListener.class);

    @RabbitListener(queues = "hello")
    public void receiveMessage(final Message message) {
        log.info(message.toString());
    }

}