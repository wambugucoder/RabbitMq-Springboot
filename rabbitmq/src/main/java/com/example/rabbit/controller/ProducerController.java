package com.example.rabbit.controller;

import com.example.rabbit.model.MessageModel;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
public class ProducerController {
    @Autowired
    private RabbitTemplate template;
    @Autowired
    private TopicExchange topicExchange;



    @PostMapping("/send/{topic}")
    public String SendFanoutMessage(@PathVariable String topic,@RequestBody String message){
        MessageModel messageModel=new MessageModel();
        messageModel.setId(UUID.randomUUID());
        messageModel.setMessage(message);
        messageModel.setDeliveredAt(LocalDateTime.now().toString());
        template.convertAndSend(topicExchange.getName(),topic,messageModel);
        return "Message Sent to queue";
    }
}
