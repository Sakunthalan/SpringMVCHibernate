package com.niit.shop.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shop.shopback.dao.CategoryDao;
import com.niit.shop.shopback.dao.ProductDao;
import com.niit.shop.shopback.dao.SupplierDao;
import com.niit.shop.shopback.model.Category;
import com.niit.shop.shopback.model.Product;
import com.niit.shop.shopback.model.Supplier;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private SupplierDao supplierdao;
	
	@Autowired
	private CategoryDao categorydao;
	
	@Autowired
	private ProductDao productdao;
	
	@RequestMapping(value = "/adminPage")
	public ModelAndView adminPage()
	{
		ModelAndView mv = new ModelAndView("adminPage");
        return mv; 
	}
	
	@ModelAttribute
	public void addAttributes(Model model)
	{
		model.addAttribute("plist", productdao.productList());
		model.addAttribute("slist", supplierdao.supplierList());
		model.addAttribute("clist",categorydao.categoryList());
	}

	@RequestMapping(value="/saveSupplier",method = RequestMethod.POST)
	public ModelAndView addSupplier(HttpServletRequest request, HttpServletResponse response)
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierId(request.getParameter("sid"));
		supplier.setSupplierName(request.getParameter("sname"));
		supplierdao.addSupplier(supplier);
		return new ModelAndView("redirect:adminPage");		
	}
	
	@RequestMapping(value="/saveCategory",method = RequestMethod.POST)
	public ModelAndView addCategory(@RequestParam("cid") String cid, @RequestParam("cname") String cname)
	{
		Category category=new Category();
		ModelAndView mv = new ModelAndView("redirect:adminPage");
		category.setCategoryId(cid);
		category.setCategoryName(cname);
		categorydao.insertCategory(category);
		return mv;		
	}
	
	@RequestMapping(value= "/saveProduct",method = RequestMethod.POST)
	public String addProduct(HttpServletRequest request, @RequestParam("file")MultipartFile file)
	{
		Product product = new Product();
		product.setPname(request.getParameter("prodname"));
		product.setPrice(Float.parseFloat(request.getParameter("prodprice")));
		product.setCategory(categorydao.get(request.getParameter("prodCategory")));
		product.setSupplier(supplierdao.get(request.getParameter("prodSupplier")));
		product.setStock(Integer.parseInt(request.getParameter("prodstock")));
		product.setDescription(request.getParameter("proddesc"));	
		String filePath = request.getSession().getServletContext().getRealPath("/");
		//System.out.println("==========="+filePath);
		String fileName = file.getOriginalFilename();
		product.setImgName(fileName);
		productdao.insertProduct(product);
		try
		{
			byte imagebyte[] = file.getBytes();
			BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(filePath+"/resources/"+fileName));
			os.write(imagebyte);
			os.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
			
        return "redirect:adminPage"; 	
	}
	
	@RequestMapping(value= "/view")
	public ModelAndView view()
	{
		ModelAndView mv = new ModelAndView("view");
        return mv; 		
	}
				
	@RequestMapping("/adminProductList")
	public ModelAndView adminProductList()
	{
		ModelAndView mv = new ModelAndView("adminProductList");
		return mv;
	}
	
	@RequestMapping("/search")
	public ModelAndView adminSearch(@RequestParam("cname") String cname)
	{
		List<Product> plist = new ArrayList<Product>();
		List<Product> list = productdao.productList();
		for(Product p : list)
		{
			if(p.getCategory().getCategoryName().equalsIgnoreCase(cname))
			{
				plist.add(p);
			}
		}
		ModelAndView mv = new ModelAndView("adminProductList","plist",plist);
		return mv;
	}
	
	@RequestMapping(value = "/updateProduct")
	public ModelAndView updateProduct(@RequestParam("pid") int pid)
	{
		//List<Category> clist=categorydao.categoryList();  
		//List<Supplier> slist=supplierdao.supplierList();
		ModelAndView mv = new ModelAndView("updateProduct");
		Product product = productdao.get(pid);
		mv.addObject("plist",product);
		//mv.addObject("slist",slist);			
		//mv.getModelMap().addAttribute("clist",clist);
        return mv; 
	}
	
	@RequestMapping(value= "/updateProduct",method = RequestMethod.POST)
	public String updateProduct(HttpServletRequest request, @RequestParam("file")MultipartFile file, @RequestParam("pid") int pid)
	{
		Product product = new Product();
		product.setPid(pid);
		product.setPname(request.getParameter("prodname"));
		product.setPrice(Float.parseFloat(request.getParameter("prodprice")));
		product.setCategory(categorydao.get(request.getParameter("prodCategory")));
		product.setSupplier(supplierdao.get(request.getParameter("prodSupplier")));
		product.setStock(Integer.parseInt(request.getParameter("prodstock")));
		product.setDescription(request.getParameter("proddesc"));	
		String filePath = request.getSession().getServletContext().getRealPath("/");
		//System.out.println("==========="+filePath);
		String fileName = file.getOriginalFilename();
		product.setImgName(fileName);
		productdao.insertProduct(product);
		try
		{
			byte imagebyte[] = file.getBytes();
			BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(filePath+"/resources/"+fileName));
			os.write(imagebyte);
			os.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
			
        return "redirect:adminProductList?update"; 	
	}
	
	@RequestMapping(value="/deleteProduct/{pid}")
	public String deleteProd(@PathVariable("pid") int pid)
	{
		productdao.deleteProduct(pid);
		return "redirect:/admin/adminProductList";
	}	

}
