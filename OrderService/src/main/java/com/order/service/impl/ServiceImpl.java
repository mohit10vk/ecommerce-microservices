package com.order.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.order.dto.Inventory;
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
		
		
		Inventory inventory = restTemplate.getForObject("http://INVENTORYSERVICE/inventory/"
				+ order.getProductId(),
				Inventory.class);
		
		if(inventory == null || inventory.getQuantity() <= 0) {
			
			order.setStatus("OUT OF STOCK");
			
			return orderRepository.save(order);
			
		}
		
	     String response = restTemplate.postForObject("http://PAYMENTSERVICE/payment/pay",
				order, 
				String.class);
	     
	     restTemplate.put(
	             "http://INVENTORYSERVICE/inventory/"
	             + order.getProductId()
	             + "/"
	             + order.getQuantity(),
	             null);
		
             order.setStatus(response);
	   return orderRepository.save(order);
	}

	@Override
	public Optional<Order> getOrderById(Long id) {
		return orderRepository.findById(id);
	}

	

}
