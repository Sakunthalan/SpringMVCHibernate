package com.niit.shop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shop.shopback.dao.CategoryDao;
import com.niit.shop.shopback.dao.SupplierDao;
import com.niit.shop.shopback.model.Category;
import com.niit.shop.shopback.model.Supplier;

@Controller
public class AdminController {

	@Autowired
	private SupplierDao supplierdao;
	
	@Autowired
	private CategoryDao categorydao;
	
	@RequestMapping(value="/adminPage",method=RequestMethod.GET)
	public ModelAndView adminPage()
	{
		return new ModelAndView("adminPage");
	}
	
	@RequestMapping(value="/saveSupplier",method = RequestMethod.POST)
	public ModelAndView addSupplier(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mv = new ModelAndView("adminPage");
		Supplier supplier = new Supplier();
		supplier.setSupplierId(request.getParameter("sid"));
		supplier.setSupplierName(request.getParameter("sname"));
		supplierdao.addSupplier(supplier);
		return mv;		
	}
	
	@RequestMapping(value="/saveCategory",method = RequestMethod.POST)
	public ModelAndView addCategory(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mv = new ModelAndView("adminPage");
		Category category = new Category();
		category.setCategoryId(request.getParameter("cid"));
		category.setCategoryName(request.getParameter("cname"));
		categorydao.insertCategory(category);
		return mv;		
	}
}
