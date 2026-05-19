package com.orderSerivce.details.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orderSerivce.details.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
