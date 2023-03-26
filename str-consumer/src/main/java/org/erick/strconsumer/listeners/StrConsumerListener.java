package org.erick.strconsumer.listeners;

import org.erick.strconsumer.custom.StrConsumerCustomListener;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class StrConsumerListener {
	
	@StrConsumerCustomListener(groupId = "group-1")
	public void listener0(String message) {
		log.info("0 Received message: {}", message);
	}
	
	@StrConsumerCustomListener(groupId = "group-1")
	public void listener2(String message) {
		log.info("1 Received message: {}", message);
	}
	
	@StrConsumerCustomListener(groupId = "group-2")
	public void listener3(String message) {
		log.info("2 Received message: {}", message);
	}
	
	@StrConsumerCustomListener(groupId = "group-2")
	public void listener4(String message) {
		log.info("3 Received message: {}", message);
	}
	
}