package com.secure_login_out.demo.Controller;
import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.secure_login_out.demo.Model.Product;
import com.secure_login_out.demo.Model.User;
import com.secure_login_out.demo.Repository.ProductRepository;
import com.secure_login_out.demo.Repository.UserRepository;
@Controller
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private ProductRepository ProdRepo;
	@ModelAttribute
	private void userDetails(Model model,Principal p)
	{
		String email=p.getName();
		User user=userRepo.findByEmail(email);
		model.addAttribute("user",user);
	}
	@GetMapping("/")
	public String home()
	{
		return "user/home";
	}
	@GetMapping("/products")
	public String showprod(Model model)
	{
		List<Product> listprod=(List<Product>) ProdRepo.findAll();
		model.addAttribute("listprod",listprod);
		return "user/products";
	}
	@GetMapping("/order")
	public String login( ) {
		return "order";
	}

}
