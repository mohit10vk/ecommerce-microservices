package com.inventory.service.service;



import java.util.Optional;

import com.inventory.service.entity.Inventory;

public interface InventoryService {
	
	Inventory createInventory(Inventory inventory);
	
	Inventory updateInventory(Long id, int quantity);
	
	Optional<Inventory> getInventoryById(Long id);
}
