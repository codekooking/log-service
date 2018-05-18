package com.codekooking.logservice.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codekooking.logservice.beans.Order;
import com.codekooking.logservice.model.OrderMessageSender;

@RestController
@RequestMapping("/log")
public class LogController {
	
	private final OrderMessageSender orderMessageSender;
	
	@Autowired
    public LogController(OrderMessageSender orderMessageSender) {
        this.orderMessageSender = orderMessageSender;
    }
    
    @PostMapping("/send-message")
    public Order handleMessage(Order order) {
        orderMessageSender.sendOrder(order);
        return order;
    }
}
