package com.orderSerivce.details.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderSerivce.details.entity.Order;
import com.orderSerivce.details.service.OrderService;


@RestController
@RequestMapping("/order")
public class OrderController {
	
	private final OrderService orderService;
	
	 public OrderController(OrderService orderService) {
	        this.orderService = orderService;
	 }
	
	@PostMapping
	public Order createOrder(@RequestBody Order order) {

	    System.out.println(order);

	    return orderService.createOrder(order);
	}
	
	@GetMapping("/{id}")
	public Optional<Order> getOrder(@PathVariable Long id) {
		return orderService.getOrderById(id);
		
	}

}
