package com.codekooking.logservice.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.codekooking.logservice.beans.Order;
import com.codekooking.logservice.configs.RabbitConfig;

@Component
public class OrderMessageListener {

    static final Logger logger = LoggerFactory.getLogger(OrderMessageListener.class);

    @RabbitListener(queues = RabbitConfig.QUEUE_NAME)
    public void processOrder(Order order) {
        logger.info("Order Received: "+order);
    }
}
