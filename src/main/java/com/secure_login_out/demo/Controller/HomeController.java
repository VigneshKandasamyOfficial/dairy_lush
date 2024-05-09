package com.secure_login_out.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.secure_login_out.demo.Model.User;
import com.secure_login_out.demo.Service.UserService;

@Controller
public class HomeController {
	@Autowired
	private UserService userSer;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/signin")
	public String login() {
		return "login";
	}
    
	@GetMapping("/products")
	public String products() {
		return "products";
	}

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@PostMapping("/newuser")
	public String newuser(User user, RedirectAttributes ra) {
		boolean res = userSer.checkEmail(user.getEmail());
		if (res) {
			ra.addFlashAttribute("message", "Email Id already exists");
			return "redirect:/register";
		} else {
			userSer.createUser(user);
			ra.addFlashAttribute("message", "Registered Succesflly");
			return "redirect:/register";
		}

	}

	@GetMapping("/order")
	public String order() {
		return "order";
	}

}
