package com.santosh.orderlocationpopup.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {
	
	@MessageMapping("/subscribe")
	@SendTo("/topic/orderNotification")
	public String join() {
		// This message will be broadcasted to the clients subscribed to /topic/orderNotification
		return new String("Subscribed Successfully!!! Get ready for order notifications!!!");
	}
}
