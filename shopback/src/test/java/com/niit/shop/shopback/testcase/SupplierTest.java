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
	public static  void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shop.shopback");
		context.refresh();		
		supplierdao = (SupplierDao) context.getBean("supplierdao");
	}
	

	@Test
	public void supplierCRUDTest()
	{
		//add
		supplier = new Supplier();
		supplier.setName("raja");
		supplier.setAddress("mdu");
		supplier.setContactNum("7418803793");
		assertEquals("Added", true, supplierdao.addSupplier(supplier));
		
		supplier = new Supplier();
		supplier.setName("aathi");
		supplier.setAddress("chn");
		supplier.setContactNum("7418803792");
		assertEquals("Added", true, supplierdao.addSupplier(supplier));
		
		//update
		supplier = supplierdao.get(4);
		supplier.setAddress("madurai");
		assertEquals("Updated",true, supplierdao.updateSupplier(supplier));
		
		//delete
		supplier = supplierdao.get(5);
		assertEquals("Deleted",true, supplierdao.deleteSupplier(supplier));
		
		//list
		assertEquals("Successfully displayed",3, supplierdao.supplierList().size());

	}
	
	
	
	
	
	
	
	
	
	
}
