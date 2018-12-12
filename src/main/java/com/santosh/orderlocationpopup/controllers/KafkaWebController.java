package com.santosh.orderlocationpopup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.santosh.orderlocationpopup.models.OrderInfo;
import com.santosh.orderlocationpopup.producers.KafkaProducer;

@Controller
public class KafkaWebController {
	@Autowired
	KafkaProducer kafkaSender;

    @RequestMapping(value = "/kafka/{topicName}", method = RequestMethod.POST)
    public String sendToTopic(@PathVariable String topicName, @RequestBody OrderInfo location) {
    	try {
    		kafkaSender.send(topicName, location);
            return "Message sent";
    	}
    	catch(Exception e) {
    		System.out.println(e.getStackTrace());
    	}
    	return "";
    }
}
