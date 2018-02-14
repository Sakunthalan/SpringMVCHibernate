package com.niit.shop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shop.shopback.dao.CategoryDao;
import com.niit.shop.shopback.dao.ProductDao;
import com.niit.shop.shopback.dao.SupplierDao;
import com.niit.shop.shopback.dao.UserDao;
import com.niit.shop.shopback.model.User;

@Controller
public class HomeController {

	@Autowired
	private UserDao userdao;
	
	@Autowired
	private ProductDao productdao;
	
	@Autowired
	private CategoryDao categorydao;
	
	@Autowired
	private SupplierDao supplierdao;
	
	@RequestMapping(value= {"/","home"},method=RequestMethod.GET)
	public ModelAndView index()
	{
		ModelAndView mv = new ModelAndView("home");
		return mv;
	}
	
	@RequestMapping(value="/login")
	public ModelAndView login()
	{
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="/logPage")
	public String logPage()
	{
		return "redirect:home";
	}
	
	@RequestMapping("/error")
	public ModelAndView error() {
		return new ModelAndView("error");
	}
	
	@RequestMapping("/userDenied")
	public ModelAndView userDenied() {
		return new ModelAndView("userDenied");
	}
			
	@RequestMapping(value="/register")
	public ModelAndView register()
	{
		ModelAndView mv = new ModelAndView("register");
		return mv;
	}
	
	@ModelAttribute
	public void addAttributes(Model model)
	{
		model.addAttribute("plist", productdao.productList());
		model.addAttribute("slist", supplierdao.supplierList());
		model.addAttribute("clist",categorydao.categoryList());
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
	
	@RequestMapping(value="/custProductList")
	public ModelAndView custProductList(@RequestParam ("categoryId") String cid)
	{
		//System.out.println("==================="+cid);
		ModelAndView mv = new ModelAndView("custProductList");
		mv.addObject("prodList",productdao.getProdByCategoryId(cid));
		return mv;  
	}
		
}

