package com.springwithqueue.service;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;

@MessageEndpoint(value="queueService")
public class QueueService {

	
	@ServiceActivator(inputChannel="queueChannel", autoStartup="true")
	public void procesQueue(Message<String> msg){
		String str = msg.getPayload();
		System.out.println(str);
		//Message<String> newMsg = MessageBuilder.withPayload(str +"Balram").build();
		
	}
}
