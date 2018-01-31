package com.niit.shop.shopback.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="SupplierTable")
public class Supplier {

	@Id
	private String supplierId;
	private String supplierName;
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}	
}
