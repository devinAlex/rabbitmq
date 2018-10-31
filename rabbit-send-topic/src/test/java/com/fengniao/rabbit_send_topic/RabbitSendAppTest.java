package com.fengniao.rabbit_send_topic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=RabbitSendApp.class)
public class RabbitSendAppTest 
{
	@Autowired
	private UserSender userSender;
	
	@Autowired
	private ProductSender productSender;
	
	@Autowired
	private OrderSender orderSender;
	
	@Test
	public void send() throws InterruptedException{
		this.userSender.send();
		this.productSender.send();
		this.orderSender.send();
	}
}
