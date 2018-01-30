package com.niit.shop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shop.shopback.dao.SupplierDao;
import com.niit.shop.shopback.model.Supplier;

@Controller
public class HomeController {

	@Autowired
	private SupplierDao supplierdao;
	
	@RequestMapping(value= {"/","home"},method=RequestMethod.GET)
	public ModelAndView index()
	{
		ModelAndView mv = new ModelAndView("home");
		return mv;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView register()
	{
		ModelAndView mv = new ModelAndView("add");
		return mv;
	}
	
	@RequestMapping(value="/add",method = RequestMethod.POST)
	public ModelAndView addSupplier(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mv = new ModelAndView("home");
		Supplier supplier = new Supplier();
		supplier.setName(request.getParameter("name"));
		supplier.setAddress(request.getParameter("address"));
		supplier.setContactNum(request.getParameter("contactNum"));
		supplierdao.addSupplier(supplier);
		return mv;		
	}
	
	@RequestMapping(value="/view")
	public ModelAndView suppliersList(HttpServletRequest request)
	{
		List<Supplier> list=supplierdao.supplierList();  
		ModelAndView mv = new ModelAndView("view");
		mv.addObject("list",list);
		return mv;  
	}
}
