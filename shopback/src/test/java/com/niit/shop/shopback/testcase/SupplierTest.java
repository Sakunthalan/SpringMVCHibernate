package com.niit.shop.shopback.testcase;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shop.shopback.dao.SupplierDao;
import com.niit.shop.shopback.model.Supplier;

public class SupplierTest {

	static Supplier supplier;
	static SupplierDao supplierdao;
	static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shop.shopback");
		context.refresh();
		supplierdao = (SupplierDao) context.getBean("supplierdao");
	}

	@Test
	public void addSupplierTest() {
		// add
		supplier = new Supplier();
		supplier.setSupplierName("raja");
		assertEquals("Added", true, supplierdao.addSupplier(supplier));

		supplier = new Supplier();
		supplier.setSupplierName("aathi");
		assertEquals("Added", true, supplierdao.addSupplier(supplier));
	}

	@Test
	public void listSupplierTest() {
		// list
		assertEquals("Successfully displayed", 3, supplierdao.supplierList().size());
	}

	@Test
	public void updateSupplierTest() {
		// update
		supplier = supplierdao.get(4);
		supplier.setSupplierName("madurai");
		assertEquals("Updated", true, supplierdao.updateSupplier(supplier));
	}

	@Test
	public void deleteSupplierTest() {
		// delete
		supplier = supplierdao.get(5);
		assertEquals("Deleted", true, supplierdao.deleteSupplier(supplier));
	}
}
