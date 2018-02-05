package com.niit.shop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shop.shopback.dao.UserDao;
import com.niit.shop.shopback.model.User;

@Controller
public class HomeController {

	@Autowired
	private UserDao userdao;
	
	@RequestMapping(value= {"/","home"},method=RequestMethod.GET)
	public ModelAndView index()
	{
		ModelAndView mv = new ModelAndView("home");
		return mv;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView login()
	{
		return new ModelAndView("login");
	}
	
			
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public ModelAndView register()
	{
		ModelAndView mv = new ModelAndView("register");
		return mv;
	}
	
	@RequestMapping(value="/register",method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mv = new ModelAndView("home");
		User user = new User();
		user.setRole("ROLE_USER");
		user.setEnabled(false);
		user.setAddress(request.getParameter("address"));
		user.setCountry(request.getParameter("country"));
		user.setEmail(request.getParameter("email"));
		user.setMobile(request.getParameter("mobile"));
		user.setPassword(request.getParameter("password"));
		user.setUserName(request.getParameter("userName"));
		userdao.insertUser(user);
		return mv;		
	}
	
	/*@RequestMapping(value="/view")
	public ModelAndView suppliersList(HttpServletRequest request)
	{
		List<Supplier> list=supplierdao.supplierList();  
		ModelAndView mv = new ModelAndView("view");
		mv.addObject("list",list);
		return mv;  
	}*/
}
