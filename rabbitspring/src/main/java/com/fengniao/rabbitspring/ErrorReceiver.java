package com.fengniao.rabbitspring;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings=@QueueBinding(
		value= @Queue(value="${mq.config.queue.error}", autoDelete="true"),
		exchange=@Exchange(value="${mq.config.exchange}",type=ExchangeTypes.DIRECT),
		key="${mq.config.queue.error.routing.key}"
		))
public class ErrorReceiver {
	
	@RabbitHandler
	public void proces(String msg){
		System.out.println("接收到ERROR日志处理:" + msg);
	}
}
