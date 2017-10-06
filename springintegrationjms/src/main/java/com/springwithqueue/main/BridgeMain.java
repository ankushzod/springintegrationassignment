package com.springwithqueue.main;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

public class BridgeMain {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("springbean.xml");
		
		PublishSubscribeChannel pubsubChannel = context.getBean("pubsubChannelB",PublishSubscribeChannel.class);
		Message<String> msg = MessageBuilder.withPayload("Message from PubSub -> Bridge -> direct : Hi").build();
		pubsubChannel.send(msg);
	}
}
