package com.Kafka.server.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Kafka.server.Service.KafkaService;

@RestController
public class KafkaController {
	@Autowired
	KafkaService kservice;
	
	@PostMapping(value = "/publish")
	public String sendMessageToKafkaTopic(@RequestBody String message){
		return this.kservice.sendMessage(message);
	}
}
