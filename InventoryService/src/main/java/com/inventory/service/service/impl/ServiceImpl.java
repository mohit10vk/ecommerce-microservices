package com.inventory.service.service.impl;



import java.util.Optional;

import org.springframework.stereotype.Service;

import com.inventory.service.entity.Inventory;
import com.inventory.service.repository.InventoryRepository;
import com.inventory.service.service.InventoryService;
@Service
public class ServiceImpl implements InventoryService{
	
	private InventoryRepository inventoryRepository;
	
	 public ServiceImpl(InventoryRepository inventoryRepository) {
	        this.inventoryRepository = inventoryRepository;
	    }

	 
	 @Override
		public Inventory createInventory(Inventory inventory) {
		 
			return inventoryRepository.save(inventory);
		}

	@Override
	public Optional<Inventory> getInventoryById(Long id) {
		return inventoryRepository.findById(id);
	}


	@Override
	public Inventory updateInventory(Long id, int quantity) {
		
		Inventory inventory = inventoryRepository.findById(id).orElse(null);
		
		inventory.setQuantity(inventory.getQuantity() - quantity);
		
		return inventoryRepository.save(inventory);
	}


	

}
