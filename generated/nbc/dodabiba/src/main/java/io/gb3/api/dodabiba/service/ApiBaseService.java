package io.gb3.api.dodabiba.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import io.gb3.api.dodabiba.model.Person;


import io.gb3.api.dodabiba.amqp.KafkaMessageSender;

@Service
public class ApiBaseService {


	@Autowired
	private KafkaMessageSender kafkaSender;


	@Cacheable("date-now")
	public String localDate() {
		return LocalDate.now().toString();
	}

	public String hello() {
		return "Hello";
	}
	
	public void sendMessageToKafka(Person person) {
		kafkaSender.sendMessage(person);
	}

}