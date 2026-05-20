package com.payment.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.entity.Payment;
import com.payment.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	private PaymentService paymentService;
	
	
	public PaymentController(PaymentService paymentService) {
	
		this.paymentService = paymentService;
	}


	@PostMapping
	public Payment createPayment(@RequestBody Payment payment) {
		return paymentService.createPayment(payment);
	}
	
	
	@GetMapping("/{id}")
	public Optional<Payment> getPaymentById(@PathVariable Long id){
		
		return paymentService.getPaymentById(id);
	}
	
	@PostMapping("/pay")
	public String doPayment() {

	    return "PAYMENT SUCCESS";
	}

}
