package org.erick.payment.service.impl;

import java.io.Serializable;

import org.erick.payment.model.Payment;
import org.erick.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private KafkaTemplate<String, Serializable> kafkaTemplate;

	@SneakyThrows
	@Override
	public void sendPayment(Payment payment) {
		log.info("Payment received. Paylment = {}", payment);
		Thread.sleep(1000);
		
		log.info("Enviando pagamento...");
		kafkaTemplate.send("payment-topic", payment);
	}

}
