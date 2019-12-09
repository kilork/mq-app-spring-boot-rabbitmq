package com.github.kilork.mqapppublish;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publish")
public class MqAppPublishController {

    static Logger LOG = LoggerFactory.getLogger(MqAppPublishController.class);

    private final RabbitTemplate template;
    private final TopicExchange topic;

    public MqAppPublishController(RabbitTemplate template, TopicExchange topic) {
        this.template = template;
        this.topic = topic;
    }

    @PostMapping
    public void send(@RequestBody MqAppPublishMessage message) {
        template.convertAndSend(topic.getName(), "mq.app.key", message);
    }
}
