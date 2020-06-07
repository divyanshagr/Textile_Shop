package com.dbms;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dbms.dao.Employeedao;
import com.dbms.dao.Manufacturerdao;
import com.dbms.dao.Productsdao;
import com.dbms.dao.Userdao;
import com.dbms.model.Products;
import com.dbms.model.User;
import com.dbms.dao.Cartdao;

@Controller
public class MainController {

	@Autowired
	public Userdao userdao;
	@Autowired
	public Employeedao employeedao;
	@Autowired
	public Manufacturerdao manufacturerdao;
	@Autowired
	public Productsdao productsdao;
	@Autowired
	public Cartdao cartdao;
	
	@RequestMapping(value = "/")
	public String welcome(Model model) {
		model.addAttribute("name", "Home Page");
		model.addAttribute("description", "unsecured page !");
		List<Products> allprod=productsdao.dispProducts();
		model.addAttribute("allprod",allprod);
		return "home";

	}

	@RequestMapping("/admin")
	public String admin(Model model, Principal principal) {

		String loggedInUserName = principal.getName();
		model.addAttribute("user", loggedInUserName);
		model.addAttribute("name", "Spring Security Custom Login Demo");
		model.addAttribute("description", "Protected page !");
		return "admin";
	}
	
	@RequestMapping("/user")
	public String user(Model model, Principal principal) {

		String loggedInUserName = principal.getName();
		model.addAttribute("user", loggedInUserName);
		model.addAttribute("name", "Spring Security USER Custom Login Demo");
		model.addAttribute("description", "Protected page for user !");
		List<Products> allprod=productsdao.dispProducts();
		model.addAttribute("allprod",allprod);
		return "user";
	}
	
	@RequestMapping("/empl")
	public String empl(Model model, Principal principal) {

		String loggedInUserName = principal.getName();
		model.addAttribute("user", loggedInUserName);
		model.addAttribute("name", "Spring Security Custom Login Demo");
		model.addAttribute("description", "Protected page !");
		return "empl";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {

		return "login";

	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {

		return "redirect:/";

	}

	@RequestMapping(value = "/loginError", method = RequestMethod.GET)
	public String loginError(ModelMap model) {
		model.addAttribute("error", "true");
		return "login";

	}
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String register(Model model) {
		
		User user = new User();
		model.addAttribute("user", user);

		return "register";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registerProcess(@Valid @ModelAttribute("user") User user,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "register";
		}
		else {
			if(!user.getPassword().equals(user.getMpassword())) {
				model.addAttribute("error","passwords dont match");
				return "register";
			}
			if(userdao.getUser(user.getUsername())!=null) {
				model.addAttribute("error", "username exists");
				return "register";
			}
			userdao.saveOrUpdate(user);
			return "redirect:/";
		}
	}
	@RequestMapping(value="/user/cart")
	public String addtocart(HttpServletRequest request) {
		String username = request.getParameter("username");
		Long pid = Long.parseLong(request.getParameter("pid"));
		cartdao.saveOrUpdate(username,pid);
		return "redirect:/user";
		
	}
}
