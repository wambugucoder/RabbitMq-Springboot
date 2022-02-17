package com.example.rabbitconsumer.Controller;

import com.example.rabbitconsumer.model.MessageModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ConsumerController {


    @RabbitListener(queues = "queue.A")
    public void ConsumeMessageA(MessageModel messageModel){
        log.info("Queue A has Message {}",messageModel);
    }
    @RabbitListener(queues = "queue.B")
    public void ConsumeMessageB(MessageModel messageModel){
        log.info("Queue B has Message {}",messageModel);
    }
    @RabbitListener(queues = "queue.C")
    public void ConsumeMessageC(MessageModel messageModel){
        log.info("Queue C has Message {}",messageModel);
    }
    @RabbitListener(queues = "queue.D")
    public void ConsumeMessageD(MessageModel messageModel){
        log.info("Queue D has Message {}",messageModel);
    }

}
