package com.springwithqueue.service;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;

@MessageEndpoint(value = "bridgeService")
public class BridgeService {
	@ServiceActivator(inputChannel = "directChannelB", autoStartup = "true")
	public void processMsg(Message<String> msg) {
		System.out.println("Message received from bridge : " + msg.getPayload());
	}
}
