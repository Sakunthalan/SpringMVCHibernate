package com.niit.shop.shopback.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="SupplierTable")
public class Supplier {

	@Id
	private String supplierId;	
	private String supplierName;
	
	@OneToMany(targetEntity=Product.class, fetch = FetchType.EAGER, mappedBy="supplier")
	private Set<Product> products =  new HashSet<Product>(0);
	
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
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
}
