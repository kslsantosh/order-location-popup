package com.santosh.orderlocationpopup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.santosh.orderlocationpopup.models.Location;
import com.santosh.orderlocationpopup.producers.KafkaProducer;

@Controller
public class KafkaWebController {
	@Autowired
	KafkaProducer kafkaSender;

    @PostMapping("/kafka/{topicName}")
    public String sendToTopic(@PathVariable String topicName, @RequestBody String location) {
    	kafkaSender.send(topicName, location);
        return "Message sent";
    }
}
