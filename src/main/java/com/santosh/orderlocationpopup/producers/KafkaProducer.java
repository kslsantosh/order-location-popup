package com.santosh.orderlocationpopup.producers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.santosh.orderlocationpopup.models.Location;

@Component
public class KafkaProducer {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void send(String topic, String payload) {
		kafkaTemplate.send(topic, payload);
        System.out.println("Message: "+payload+" sent to topic: "+topic);
    }
}
