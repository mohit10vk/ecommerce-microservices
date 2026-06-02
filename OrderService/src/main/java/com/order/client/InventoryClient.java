package com.order.client;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.order.dto.Inventory;


@FeignClient(name="INVENTORYSERVICE")
public interface InventoryClient {

	 @GetMapping("/inventory/{id}")
	    Optional<Inventory> getInventoryById(@PathVariable Long id);
	 
	 @PutMapping("/inventory/{id}/{quantity}")
		Inventory updateInventory(
		        @PathVariable Long id,
		        @PathVariable int quantity);
}
