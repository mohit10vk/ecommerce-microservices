package com.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;



@FeignClient(name="PAYMENTSERVICE")
public interface PaymentClient {

	@PostMapping("/payment/pay")
    String doPayment();
	
	
}
