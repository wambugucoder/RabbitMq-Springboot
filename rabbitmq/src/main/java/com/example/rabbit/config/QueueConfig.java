package com.example.rabbit.config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {
    private static final String TOPIC_A="Topic-A";
    private static final String TOPIC_B="Topic-B";
    private static final String TOPIC_C="Topic-C";

    @Bean
    Queue queueA(){
        return new Queue("queue.A",false);
    }
    @Bean
    Queue queueB(){
        return new Queue("queue.B",false);
    }
    @Bean
    Queue queueC(){
        return new Queue("queue.C",false);
    }


    @Bean
    TopicExchange exchange(){
        return  new TopicExchange("exchange.topic");
    }



    @Bean
    Binding bindingA(Queue queueA, TopicExchange exchange) {
        return BindingBuilder.bind(queueA).to(exchange).with(TOPIC_A);
    }
    @Bean
    Binding bindingB(Queue queueB,TopicExchange exchange) {
        return BindingBuilder.bind(queueB).to(exchange).with(TOPIC_B);
    }
    @Bean
    Binding bindingC(Queue queueC,TopicExchange exchange) {
        return BindingBuilder.bind(queueC).to(exchange).with(TOPIC_C);
    }

    @Bean
    MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
    @Bean
    RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate= new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;

    }

}
