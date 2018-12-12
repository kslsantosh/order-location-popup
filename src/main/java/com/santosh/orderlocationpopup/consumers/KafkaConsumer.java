package com.santosh.orderlocationpopup.consumers;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.stereotype.Component;

import com.santosh.orderlocationpopup.constants.KafkaConstants;
import com.santosh.orderlocationpopup.models.Location;

@EnableKafka
@Component
public class KafkaConsumer {
		
	@KafkaListener(topics = KafkaConstants.TOPIC_NAME)
    public void receiveTopic1(String message) {
        System.out.println("Receiver on topic1: "+message);
    }
}
