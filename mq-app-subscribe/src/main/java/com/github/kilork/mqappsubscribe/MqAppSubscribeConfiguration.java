package com.github.kilork.mqappsubscribe;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqAppSubscribeConfiguration {

    private final String topic;
    private final String queue;

    public MqAppSubscribeConfiguration(@Value("${mq.app.rabbitmq.topic}") String topic,
                                       @Value("${mq.app.rabbitmq.queue}") String queue) {
        this.topic = topic;
        this.queue = queue;
    }


    @Bean
    public TopicExchange topic() {
        return new TopicExchange(topic);
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter(ObjectMapper objectMapper) {
        return new Jackson2JsonMessageConverter(objectMapper);
    }

    @Bean
    public Queue appQueueMessages() {
        return new Queue(queue);
    }

    @Bean
    public Binding declareBindingMessages() {
        return BindingBuilder.bind(appQueueMessages()).to(topic()).with("mq.app.key");
    }
}
