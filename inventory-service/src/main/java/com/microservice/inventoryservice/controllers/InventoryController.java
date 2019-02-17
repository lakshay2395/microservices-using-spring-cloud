package com.microservice.inventoryservice.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.inventoryservice.entities.InventoryItem;
import com.microservice.inventoryservice.repositories.InventoryItemRepository;

@RestController
public class InventoryController {
	
	@Autowired
	InventoryItemRepository repository;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/api/inventory/{code}")
	public ResponseEntity<InventoryItem> fingInventoryByProductCode(@PathVariable String code){
		Optional<InventoryItem> inventoryItem = repository.findByProductCode(code);
        if(inventoryItem.isPresent()) {
            return new ResponseEntity(inventoryItem, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
	}

}
