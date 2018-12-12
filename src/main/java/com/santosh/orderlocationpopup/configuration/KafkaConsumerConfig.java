package com.santosh.orderlocationpopup.configuration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.santosh.orderlocationpopup.constants.KafkaConstants;
import com.santosh.orderlocationpopup.models.OrderInfo;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {
	@Bean
    public ConsumerFactory<String, OrderInfo> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstants.KAFKA_BROKERS);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, KafkaConstants.CLIENT_ID);
        
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new JsonDeserializer<>(OrderInfo.class));
    }
	
	@Bean
    public ConcurrentKafkaListenerContainerFactory<String, OrderInfo> kafkaListenerContainerFactory() {
    
        ConcurrentKafkaListenerContainerFactory<String, OrderInfo> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        
        return factory;
    }
}
