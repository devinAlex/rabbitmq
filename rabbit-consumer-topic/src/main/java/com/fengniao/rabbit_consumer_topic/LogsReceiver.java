package com.fengniao.rabbit_consumer_topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings=@QueueBinding(
		value= @Queue(value="${mq.config.queue.logs}", autoDelete="true"),
		exchange=@Exchange(value="${mq.config.exchange}",type=ExchangeTypes.TOPIC),
		key="*.log.*"
		))
public class LogsReceiver {
	
	@RabbitHandler
	public void proces(String msg){
		System.out.println("=========ALL=======日志" + msg);
	}
}
