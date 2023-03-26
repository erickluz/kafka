package org.erick.payment.service;

import org.erick.payment.model.Payment;

public interface PaymentService {
	
	void sendPayment(Payment message);

}
