package com.niit.shop.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shop.shopback.dao.CartDao;
import com.niit.shop.shopback.dao.OrderDao;
import com.niit.shop.shopback.dao.ProductDao;
import com.niit.shop.shopback.dao.UserDao;
import com.niit.shop.shopback.model.Cart;
import com.niit.shop.shopback.model.Order;
import com.niit.shop.shopback.model.Product;
import com.niit.shop.shopback.model.User;


@Controller
public class CartController {
	
	@Autowired
	private ProductDao productdao;
	
	@Autowired 
	private CartDao cartdao;
	
	@Autowired 
	private UserDao userdao;
	
	@Autowired
	private OrderDao orderdao;
	
	@RequestMapping(value="/productDetails/{pid}")
	public ModelAndView productDetails(@PathVariable("pid") int pid)
	{
		ModelAndView mv = new ModelAndView("productDetails");
		mv.addObject("prod",productdao.get(pid));
		return mv; 
	}
	
	@RequestMapping(value="/cart")
	public ModelAndView cartview(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView("cart");
		Principal principal = request.getUserPrincipal();
		String userEmail = principal.getName();
		User user = userdao.get(userEmail);
		mv.addObject("cartInfo", cartdao.getCartByUserId(user.getId()));
		return mv;
	}
	
	@RequestMapping(value="/addCart",method=RequestMethod.POST)
	public ModelAndView addCart(HttpServletRequest request, @RequestParam("pid") int pid, @RequestParam("quantity") int quantity/*@ModelAttribute("product") Product prod*/)
	{
		ModelAndView mv = new ModelAndView("cart");
		Principal principal = request.getUserPrincipal();
		String userEmail = principal.getName();
		User user = userdao.get(userEmail);
		Product prod = productdao.get(pid);
		System.out.println("username=="+userEmail);
	//	System.out.println("product=="+prod.getPname());
		try
		{
			//int pid = Integer.parseInt(request.getParameter("pid"));
			//int quantity = Integer.parseInt(request.getParameter("quantity"));
			Double price = Double.parseDouble(prod.getPrice().toString());
			String prodName = prod.getPname();
			//String imgName=request.getParameter("imgName");
			//Cart cartItems = cartdao.get(pid, userEmail);
			Cart cartItems = cartdao.get(pid, user.getId());
			if(cartItems == null)
			{
				System.out.println("new cart");
				Cart c = new Cart();
				c.setCartImage(prod.getImgName());
				c.setCartPrice(price);
				c.setCartProductId(pid);
				c.setCartProductName(prodName);
				c.setQuantity(quantity);
				//User user = userdao.get(userEmail);
				c.setUserCartDetails(user);
				cartdao.insert(c);
			//	System.out.println("inserted new");
			}
			else if(cartItems!=null)
			{
				System.out.println("exist cart");
				Cart c = new Cart();
				c.setCartId(cartItems.getCartId());
				c.setCartPrice(price);
				c.setCartProductId(pid);
				c.setCartProductName(prodName);
				c.setQuantity(quantity);
				c.setCartImage(prod.getImgName());
				//User user = userdao.get(userEmail);
				c.setUserCartDetails(user);
				cartdao.updateCart(c);
			//	System.out.println("inserted in exist");
			}
			mv.addObject("cartInfo", cartdao.getCartByUserId(user.getId()));
			return mv;
		}
		catch(Exception e) {
			System.out.println("exception");
			mv.addObject("cartInfo", cartdao.getCartByUserId(user.getId()));
			return mv;
		}		
	}
	
	@RequestMapping(value="/deleteCart/{cartId}")
	public String deleteCart(@PathVariable("cartId") int cartId)
	{
		cartdao.deleteCart(cartId);
		return "redirect:/cart";
	}	
	
	@RequestMapping(value="checkout")
	public ModelAndView checkout(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView("checkout");
		Principal principal = request.getUserPrincipal();
		String userEmail = principal.getName();
		User user = userdao.get(userEmail);
		List<Cart> cart = cartdao.getCartByUserId(user.getId());
		mv.addObject("user", user);
		mv.addObject("cart", cart);
		return mv;
	}
	
	@RequestMapping(value="/invoice",method=RequestMethod.POST)
	public ModelAndView saveInvoice(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView("invoice");
		Order order = new Order();
		Principal principal = request.getUserPrincipal();
		String userEmail = principal.getName();
		User user = userdao.get(userEmail);
		Double total = Double.parseDouble(request.getParameter("total"));
		String payment = request.getParameter("payment");
		order.setPayment(payment);
		order.setTotal(total);
		order.setUser(user);
		orderdao.insert(order);
		return mv;
	}
}
