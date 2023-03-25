package org.erick.strconsumer.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class StrConsumerListener {
	
	@KafkaListener(groupId = "group-1",
			topicPartitions = {
					@TopicPartition(topic = "str-topic", partitions = {"0"})
			},
			containerFactory = "strContainerFactory")
	public void listener0(String message) {
		log.info("0 Received message: {}", message);
	}
	
	@KafkaListener(groupId = "group-1", 
			topicPartitions = {
					@TopicPartition(topic = "str-topic", partitions = {"1"})
			},
			containerFactory = "strContainerFactory")
	public void listener2(String message) {
		log.info("1 Received message: {}", message);
	}
	
	@KafkaListener(groupId = "group-2", topics ="str-topic", containerFactory = "strContainerFactory")
	public void listener3(String message) {
		log.info("2 Received message: {}", message);
	}
	
	@KafkaListener(groupId = "group-2", topics ="str-topic", containerFactory = "strContainerFactory")
	public void listener4(String message) {
		log.info("3 Received message: {}", message);
	}
	
}
