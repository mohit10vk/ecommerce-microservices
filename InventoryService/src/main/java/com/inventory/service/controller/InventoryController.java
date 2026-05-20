package com.inventory.service.controller;



import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.service.entity.Inventory;
import com.inventory.service.service.InventoryService;



@RestController
@RequestMapping("/inventory")
public class InventoryController {
	
	private InventoryService inventoryService;
	

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }
    
	@PostMapping
	public Inventory createInventory(@RequestBody Inventory inventory) {
		  
		return inventoryService.createInventory(inventory);
	}
	
	@GetMapping("/{id}")
	public Optional<Inventory> getinventoryById(@PathVariable Long id) {
		return inventoryService.getinventoryById(id);
	}
}
