package com.orderSerivce.details.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderSerivce.details.entity.Order;
import com.orderSerivce.details.repository.OrderRepository;
import com.orderSerivce.details.service.OrderService;


@Service
public class OrderImpl implements OrderService{

	@Autowired
	private OrderRepository orderRepository;
	 
	public OrderImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
	}
	
	

	@Override
	public List<Order> getOrderList(){
		return orderRepository.findAll();
	}



	@Override
	public Order createOrder(Order order) {
		order.setStatus("Sccessfully Created");;
		return orderRepository.save(order);
	}



	@Override
	public Optional<Order> getOrderById(Long id) {
		return orderRepository.findById(id);
	}
	
	
}
