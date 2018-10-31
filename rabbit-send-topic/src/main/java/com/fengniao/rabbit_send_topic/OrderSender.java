package com.fengniao.rabbit_send_topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OrderSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Value("${mq.config.exchange}")
	private String exchange;
	
	public void send() throws InterruptedException{
		this.rabbitTemplate.convertAndSend(exchange, "order.log.debug", "order.log.debug...........");
		this.rabbitTemplate.convertAndSend(exchange, "order.log.info", "order.log.info...........");
		this.rabbitTemplate.convertAndSend(exchange, "order.log.warn", "order.log.warn...........");
		this.rabbitTemplate.convertAndSend(exchange, "order.log.error", "order.log.error...........");
	}
}
