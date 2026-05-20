package com.inventory.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.service.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long>{

}
