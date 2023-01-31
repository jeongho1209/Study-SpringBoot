//package com.example.rabbitmq;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.concurrent.TimeUnit;
//
//@Component
//public class RabbitRunner implements CommandLineRunner {
//
//    private final RabbitTemplate rabbitTemplate;
//    private final Receiver receiver;
//
//    public RabbitRunner(RabbitTemplate rabbitTemplate, Receiver receiver) {
//        this.rabbitTemplate= rabbitTemplate;
//        this.receiver = receiver;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println("Sending message...");
//        rabbitTemplate.convertAndSend(RabbitProperty.topicExchangeName, "foo.bar.baz", "Hello from RabbitMQ!");
//        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
//    }
//
//}
