package com.payment.service;

import java.util.Optional;

import com.payment.entity.Payment;

public interface PaymentService {
	
	Payment createPayment(Payment payment);
	
	Optional<Payment> getPaymentById(Long id);

}
