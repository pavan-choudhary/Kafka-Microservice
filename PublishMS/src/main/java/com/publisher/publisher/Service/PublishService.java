package com.publisher.publisher.Service;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PublishService {
	@Autowired
	RestTemplate restTemplate;
	
	public String send() {
		System.out.println("Publishing started");
		try {
			for(int i=0;i<25;i++) {
				Object obj = new JSONParser().parse(new FileReader("./json/"+i+".json")); 
		        JSONObject jo = (JSONObject) obj;
		        String foo = restTemplate.postForObject("http://localhost:8201/publish",jo.toJSONString(),String.class);
				System.out.println(foo);
		        Thread.sleep(1000);
			}
			return "Success";
		}  catch (org.json.simple.parser.ParseException e) {
			e.printStackTrace();
			return "error in parsing JSON";
		}
		catch (InterruptedException e) {
			return "Some error occured";
		}
		catch (Exception e) {
			e.printStackTrace();
			return "Cannot find files";
		}	
	}
}
