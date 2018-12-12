package com.santosh.orderlocationpopup.producers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.santosh.orderlocationpopup.models.Location;

@Component
public class KafkaProducer {
	
	@Autowired
	private KafkaTemplate<String, Location> kafkaTemplate;
	
	public void send(String topic, Location location) {
		kafkaTemplate.send(topic, location);
		System.out.println("Producer latitude : "+location.getLatitude());
        System.out.println("Producer longitude : "+location.getLongitude());
        System.out.println("Message: "+location+" sent to topic: "+topic);
    }
}
