package com.santosh.orderlocationpopup.consumers;

import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.santosh.orderlocationpopup.constants.KafkaConstants;
import com.santosh.orderlocationpopup.models.Location;

@EnableKafka
@Component
public class KafkaConsumer {
		
	@KafkaListener(topics = KafkaConstants.TOPIC_NAME)
    public void receiveLocation(Location location) {
        System.out.println("Receiver on topic1 Latitude: "+location.getLatitude());
        System.out.println("Receiver on topic1 Longitude: "+location.getLongitude());
    }
}
