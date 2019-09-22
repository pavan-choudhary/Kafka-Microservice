package com.Kafka.server.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
	private static final String TOPIC = "heartRate";
	@Autowired
	private KafkaTemplate<String,String> kafkaTemplate;
	
	public String sendMessage(String s) {
		try {
			System.out.println(s);
			this.kafkaTemplate.send(TOPIC,s);
			return "Success";
		} catch (Exception e) {
			return "Failed to send";
		}
	}
}
