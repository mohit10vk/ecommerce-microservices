package com.payment.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.entity.Payment;
import com.payment.repository.PaymentRepository;
import com.payment.service.PaymentService;

@Service
public class PaymentImpl implements PaymentService{
	
	@Autowired
	private PaymentRepository paymentRepository;
	

	public PaymentImpl(PaymentRepository paymentRepository) {
	
		this.paymentRepository = paymentRepository;
	}

	@Override
	public Payment createPayment(Payment payment) {
		payment.setStatus("SUCCESSFULLY");
		return paymentRepository.save(payment);
	}

	@Override
	public Optional<Payment> getPaymentById(Long id) {
		return paymentRepository.findById(id);
	}
	
	

}
