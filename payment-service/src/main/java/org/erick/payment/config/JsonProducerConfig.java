package org.erick.payment.config;

import java.io.Serializable;
import java.util.HashMap;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
public class JsonProducerConfig {
	@Autowired
	private KafkaProperties properties;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public ProducerFactory jsonProducerFactory() {
		var configs = new  HashMap<String, Object>();
		configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());
		configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory(configs, new StringSerializer(), new JsonSerializer<>());
	}
	
	public KafkaTemplate<String, Serializable> jsonKafkaTemplate(ProducerFactory<String, Serializable> jsonProducerFactory) {
		return new KafkaTemplate<>(jsonProducerFactory);
	}
	
}
