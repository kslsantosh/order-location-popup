package com.santosh.orderlocationpopup.consumers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.santosh.orderlocationpopup.constants.KafkaConstants;
import com.santosh.orderlocationpopup.constants.WebSocketConstants;
import com.santosh.orderlocationpopup.models.OrderInfo;
import com.santosh.orderlocationpopup.producers.WebSocketPublisher;

@EnableKafka
@Component
public class KafkaConsumer {
	
	@Autowired
	WebSocketPublisher webSocketPublisher;
	
	@KafkaListener(topics = KafkaConstants.TOPIC_NAME)
    public void receiveLocation(OrderInfo location) {
        System.out.println("Receiver on topic1 Latitude: "+location.getLatitude());
        System.out.println("Receiver on topic1 Longitude: "+location.getLongitude());
        webSocketPublisher.publishMessage(WebSocketConstants.WS_ORDER_NOTIFICATION_TOPIC, location);
    }
}
