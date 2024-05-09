package com.secure_login_out.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.secure_login_out.demo.Model.Product;
import com.secure_login_out.demo.Repository.ProductRepository;
import com.secure_login_out.demo.exception.ProductNotFoundException;


@Controller
@RequestMapping(value="/admin")
public class MainController {
	@Autowired
	private ProductRepository ProdRepo;
	@GetMapping("/")
	public String showhomepage()
	{
		return "admin/product";
	}
	@GetMapping("/view_product")
	public String showprod(Model model)
	{
		List<Product> listprod=(List<Product>) ProdRepo.findAll();
		model.addAttribute("listprod",listprod);
		return "admin/product";
	}
	@GetMapping("/prod/new")
	public String showform(Model model)
	{
		model.addAttribute("prod",new Product());
		model.addAttribute("pageTitle", "Add New Medicine");
		return "admin/prod_form";
	}
	@PostMapping("/prod/save")
	public String addcust(Product prod, RedirectAttributes ra)
	{
		ProdRepo.save(prod);
		ra.addFlashAttribute("message","The user data has been saved Successfully");
		return "redirect:/admin/view_product";
	}
	
	@GetMapping("/prod/edit/{id}")
	public String get(@PathVariable Integer id,Model model,RedirectAttributes ra)
	{
		try
		{
		Optional<Product> prod=ProdRepo.findById(id);
		if(prod.isPresent())
		{
			model.addAttribute("prod",prod.get());
			model.addAttribute("pageTitle", "Edit  (ID: " +id+ ")");
			return "admin/prod_form";
		}
		throw new ProductNotFoundException("Could Not Found any user with ID "+id);
		
		}
		catch(ProductNotFoundException e)
		{
			ra.addFlashAttribute("message",e.getMessage());
		}
		return "redirect:/admin/view_product";
		
		
		
	}
	
	@GetMapping("/prod/delete/{id}")
	public String deletecust(@PathVariable Integer id,RedirectAttributes ra)
	{
		try {
		Long count=ProdRepo.countById(id);
		if(count==null || count==0)
		{
			throw new ProductNotFoundException("Could not find user with ID "+id);
		}
		ProdRepo.deleteById(id);
		ra.addFlashAttribute("message","The user with ID "+id+" has been deleted");
		}
		catch(ProductNotFoundException e)
		{
			ra.addFlashAttribute("message",e.getMessage());
			
		}
		return "redirect:/admin/view_product";
	}
	

}
