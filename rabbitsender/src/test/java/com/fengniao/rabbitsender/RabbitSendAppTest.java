package com.fengniao.rabbitsender;

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
	private Sender sender;
	
	@Test
	public void send() throws InterruptedException{
		this.sender.send();
	}
}
