package com.microservice.catalogservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.catalogservice.entities.Product;
import com.microservice.catalogservice.exceptions.ProductNotFoundException;
import com.microservice.catalogservice.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping("")
	public List<Product> getAllProducts(){
		return productService.findAllProducts();
	}
	
	@GetMapping("/{code}")
	public Product productByCode(@PathVariable String code) {
		return productService.findByCode(code).orElseThrow(() -> new ProductNotFoundException("Product with code "+code+" does not exists"));
	}
	
}
