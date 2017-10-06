package com.springwithqueue.main;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.integration.IntegrationMessageHeaderAccessor;
import org.springframework.integration.channel.PriorityChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

public class MainApp {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("springbean.xml");
		//MessageChannel msgChannel = context.getBean("msgChannel", MessageChannel.class);
		QueueChannel queue = context.getBean("queueChannel", QueueChannel.class);
		System.out.println("QUEUE Channel Examples");	
		String names[] = {"BB", "DD", "FF","GG", "EE", "CC","AA"};
		for(String name : names){
		Message<String> msg = MessageBuilder.withPayload(name).build();
		queue.send(msg);
		}
		
		System.out.println("PRIORITY Channel Examples");		 
		PriorityChannel prChannel = context.getBean("priorityChannel", PriorityChannel.class);
		String cities[] = {"Kolhapur","Pune", "Mumbai","Akola"};
		for(int i=0; i<cities.length; i++){
			Message<String> prmsg = MessageBuilder.withPayload(cities[i])
					.setHeader(IntegrationMessageHeaderAccessor.PRIORITY, i).build();
			prChannel.send(prmsg);
		}
		
		
	}

}
