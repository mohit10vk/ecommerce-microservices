package com.order.service;

import java.util.Optional;

import com.order.entity.Order;


public interface OrderService {
	
	Order createOrder(Order order);
	
	Optional<Order> getOrderById(Long id);

}
