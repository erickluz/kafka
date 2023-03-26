package org.erick.strconsumer.listener;

import org.erick.strconsumer.model.Payment;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class JsonListener {
	
	@KafkaListener(topics = "payment-topic", groupId = "create-group", containerFactory = "jsonContainerFactory")
	public void consume(@Payload Payment payment) {
		log.info("Json received = Object = {}", payment);
	}
	
}
