package com.orderSerivce.details.service;

import java.util.List;
import java.util.Optional;

import com.orderSerivce.details.entity.Order;

public interface OrderService {

	
	 List<Order> getOrderList();
	 
	 Order createOrder(Order order);
	
	 Optional<Order> getOrderById(Long id);
}
