package com.order.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

import com.order.client.InventoryClient;
import com.order.client.PaymentClient;
import com.order.config.AppConfig;
import com.order.dto.Inventory;
import com.order.dto.PaymentResponse;
import com.order.entity.Order;
import com.order.event.OrderCreatedEvent;
import com.order.repository.OrderRepository;
import com.order.service.OrderEventProducer;
import com.order.service.OrderService;


@Service
public class ServiceImpl implements OrderService{

    private final AppConfig appConfig;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private InventoryClient inventoryClient;

	@Autowired
	private PaymentClient paymentClient;
	
	@Autowired
	private OrderEventProducer orderEventProducer;

    ServiceImpl(AppConfig appConfig) {
        this.appConfig = appConfig;
    }
	
	@Override
	public Order createOrder(Order order) {
		
		
		Optional<Inventory> inventoryOpt =
		        inventoryClient.getInventoryById(
		        order.getProductId());

		Inventory inventory =
		        inventoryOpt.orElse(null);
		
		if(inventory == null || inventory.getQuantity() <= 0) {
			
			order.setStatus("OUT OF STOCK");
			
			return orderRepository.save(order);
			
		}
		
		String response =
		        paymentClient.doPayment();
	     
		inventoryClient.updateInventory(
		        order.getProductId(),
		        order.getQuantity());
		
		order.setStatus(response);

		Order savedOrder = orderRepository.save(order);

		 orderEventProducer.publish( new OrderCreatedEvent( savedOrder.getOrderId(),
		  String.valueOf(savedOrder.getProductId())) );
		 

		return savedOrder;
	}

	@Override
	public Optional<Order> getOrderById(Long id) {
		return orderRepository.findById(id);
	}

	

}
