package com.github.kilork.mqappsubscribe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MqAppSubscribeService {
    static Logger LOG = LoggerFactory.getLogger(MqAppSubscribeService.class);

    @RabbitListener(queues = "${mq.app.rabbitmq.queue}")
    public void receiveMessage(MqAppSubscribeMessage message) {
        LOG.info("Received message: {}", message);
    }
}
