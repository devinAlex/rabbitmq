package com.fengniao.rabbit_send_topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProductSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Value("${mq.config.exchange}")
	private String exchange;
	
	public void send() throws InterruptedException{
		this.rabbitTemplate.convertAndSend(exchange, "product.log.debug", "product.log.debug...........");
		this.rabbitTemplate.convertAndSend(exchange, "product.log.info", "product.log.info...........");
		this.rabbitTemplate.convertAndSend(exchange, "product.log.warn", "product.log.warn...........");
		this.rabbitTemplate.convertAndSend(exchange, "product.log.error", "product.log.error...........");
	}
}
