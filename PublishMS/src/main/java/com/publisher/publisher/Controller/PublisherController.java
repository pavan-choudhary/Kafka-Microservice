package com.publisher.publisher.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.publisher.publisher.Service.PublishService;

@RestController
public class PublisherController {
	@Autowired
	PublishService publish;
	
	@RequestMapping(value = "/start", method = RequestMethod.GET)
	public String start() {
		return publish.send();
	}
}
