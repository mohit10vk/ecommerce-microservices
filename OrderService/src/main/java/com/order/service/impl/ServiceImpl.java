package com.order.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.order.dto.PaymentResponse;
import com.order.entity.Order;
import com.order.repository.OrderRepository;
import com.order.service.OrderService;




@Service
public class ServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Order createOrder(Order order) {
	     String response = restTemplate.postForObject("http://localhost:2224/payment/pay",
				order, 
				String.class);
		
             order.setStatus(response);
	   return orderRepository.save(order);
	}

	@Override
	public Optional<Order> getOrderById(Long id) {
		return orderRepository.findById(id);
	}

	

}
