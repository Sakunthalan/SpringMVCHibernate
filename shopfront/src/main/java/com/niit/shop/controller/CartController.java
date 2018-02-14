package com.niit.shop.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shop.shopback.dao.CartDao;
import com.niit.shop.shopback.dao.ProductDao;
import com.niit.shop.shopback.dao.UserDao;
import com.niit.shop.shopback.model.Cart;
import com.niit.shop.shopback.model.User;


@Controller
public class CartController {
	
	@Autowired
	private ProductDao productdao;
	
	@Autowired 
	private CartDao cartdao;
	
	@Autowired 
	private UserDao userdao;
	
	@RequestMapping(value="/productDetails/{pid}")
	public ModelAndView productDetails(@PathVariable("pid") int pid)
	{
		ModelAndView mv = new ModelAndView("productDetails");
		mv.addObject("prod",productdao.get(pid));
		return mv; 
	}
	
	@RequestMapping(value="/addCart",method=RequestMethod.POST)
	public ModelAndView addCart(HttpServletRequest request/*, @ModelAttribute("product") Product prod*/)
	{
		ModelAndView mv = new ModelAndView("cart");
		Principal principal = request.getUserPrincipal();
		String userEmail = principal.getName();
		//System.out.println("username=="+userEmail);
		//System.out.println("product=="+prod+"product=="+prod.getPname());
		try
		{
			int pid = Integer.parseInt(request.getParameter("pid"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			Double price = Double.parseDouble(request.getParameter("price"));
			String prodName = request.getParameter("pname");
			String imgName=request.getParameter("imgName");
			Cart cartItems = cartdao.get(pid, userEmail);
			if(cartItems == null)
			{
				Cart c = new Cart();
				c.setCartImage(imgName);
				c.setCartPrice(price);
				c.setCartProductId(pid);
				c.setCartProductName(prodName);
				c.setQuantity(quantity);
				User user = userdao.get(userEmail);
				c.setUserCartDetails(user);
				cartdao.insert(c);
			}
			else if(cartItems!=null)
			{
				Cart c = new Cart();
				c.setCartId(cartItems.getCartId());
				c.setCartPrice(price);
				c.setCartProductId(pid);
				c.setCartProductName(prodName);
				c.setQuantity(quantity);
				User user = userdao.get(userEmail);
				c.setUserCartDetails(user);
				cartdao.insert(c);
			}
			mv.addObject("cartInfo", cartdao.getCartByUserId(userEmail));
			return mv;
		}
		catch(Exception e) {
			mv.addObject("cartInfo", cartdao.getCartByUserId(userEmail));
			return mv;
		}		
	}
	
}
