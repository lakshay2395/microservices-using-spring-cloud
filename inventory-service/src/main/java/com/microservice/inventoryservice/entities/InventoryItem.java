package com.microservice.inventoryservice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="inventory")
public class InventoryItem {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	
	@Column(name = "product_code", nullable = false, unique = true)
	public String productCode;
	
	@Column(name = "quantity")
	public int availableQuantity = 0;

	@Override
	public String toString() {
		return "InventoryItem [id=" + id + ", productCode=" + productCode + ", availableQuantity=" + availableQuantity
				+ "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public int getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	
}
