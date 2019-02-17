package com.microservice.catalogservice.models;

public class ProductInventoryResponse {
    
	private String productCode;
    
	private int availableQuantity;

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

	@Override
	public String toString() {
		return "ProductInventoryResponse [productCode=" + productCode + ", availableQuantity=" + availableQuantity
				+ "]";
	}
}