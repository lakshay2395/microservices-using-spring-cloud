package com.microservice.catalogservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.microservice.catalogservice.entities.Product;
import com.microservice.catalogservice.models.ProductInventoryResponse;
import com.microservice.catalogservice.repositories.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	InventoryServiceClient client;
	
	org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ProductService.class);
	
	public List<Product> findAllProducts(){
		return productRepository.findAll();
	}
	
	public Optional<Product> findByCode(String code){
		Optional<Product> productOptional = productRepository.findByCode(code);
		logger.info("code = "+code);
		if(productOptional.isPresent()) {
			Optional<ProductInventoryResponse> itemResponseEntity =
                    client.getProductInventoryByCode(code);
            if (itemResponseEntity.isPresent()) {
                Integer quantity = itemResponseEntity.get().getAvailableQuantity();
                productOptional.get().setInStock(quantity > 0);
            }
		}
		return productOptional;
	}

}
