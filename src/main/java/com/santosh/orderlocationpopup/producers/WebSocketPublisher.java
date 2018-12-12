package com.santosh.orderlocationpopup.producers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import com.santosh.orderlocationpopup.models.OrderInfo;

@Configuration
public class WebSocketPublisher {
	
	@Autowired
	SimpMessagingTemplate template;
	
	public void publishMessage(String wsTopic, OrderInfo location) {
		System.out.println("Publishing message to websocket topic " + location);
		template.convertAndSend(wsTopic, location);
	}
}
