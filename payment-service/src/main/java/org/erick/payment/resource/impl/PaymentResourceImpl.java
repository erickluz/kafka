package org.erick.payment.resource.impl;

import org.erick.payment.model.Payment;
import org.erick.payment.resource.PaymentResource;
import org.erick.payment.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/payments")
public class PaymentResourceImpl implements PaymentResource {

	private final PaymentService paymentService;
	
	@Override
	public ResponseEntity<Payment> payment(Payment payment) {
		paymentService.sendPayment(payment);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}
