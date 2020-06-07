package com.dbms;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dbms.dao.Employeedao;
import com.dbms.dao.Invoicedao;
import com.dbms.dao.Manufacturerdao;
import com.dbms.dao.Productsdao;
import com.dbms.dao.Userdao;
import com.dbms.model.User;
import com.dbms.model.Cart;
import com.dbms.model.Transportentry;
import com.dbms.model.Invoice;
import com.dbms.dao.Cartdao;
import com.dbms.dao.Transportentrydao;
import com.dbms.dao.Transporterdao;

@Controller
public class UserController {

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
	@Autowired
	public Invoicedao invoicedao;
	@Autowired
	public Transportentrydao transportentrydao;
	@Autowired
	public Transporterdao transporterdao;

	@RequestMapping(value = "user/update", method = RequestMethod.GET)
	public String userupdate1(HttpServletRequest request, Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		User user = userdao.getCustomer(username);
		model.addAttribute("user", user);
		model.addAttribute("username", username);

		return "userupdate";
	}

	@RequestMapping(value = "user/update", method = RequestMethod.POST)
	public String userupdate(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "userupdate";
		} else {
			if (!user.getPassword().equals(user.getMpassword())) {
				model.addAttribute("error", "passwords don't match");
				return "userupdate";
			}
			userdao.userupdate(user);
			return "redirect:/user";
		}
	}

	@RequestMapping(value = "/user/dispuser")
	public String shuser(HttpServletRequest request, Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		List<User> alluser = userdao.dispuser(username);
		model.addAttribute("alluser", alluser);
		return "userdisp";

	}

	@RequestMapping(value = "/user/products")
	public String checker(Principal principal, Model model) {
		String user = principal.getName();
		model.addAttribute("user", user);
		model.addAttribute("product", "product");
		return "product";
	}

	@RequestMapping(value = "/user/showcart")
	public String showcart(HttpServletRequest request, Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		List<Cart> allcart = cartdao.viewCart(username);
		model.addAttribute("allcart", allcart);
		Integer cartsize=allcart.size();
		model.addAttribute("cartsize",cartsize);
		Long price = cartdao.totalPrice(username);
		model.addAttribute("price", price);
		return "showcart";
	}

	@RequestMapping(value = "/user/showcart/delete")
	public String deletecart(HttpServletRequest request, Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		Long pid = Long.parseLong(request.getParameter("pid"));
		cartdao.deleteEntry(username, pid);
		List<Cart> allcart = cartdao.viewCart(username);
		model.addAttribute("allcart", allcart);
		return "redirect:/user/showcart";
	}

	@RequestMapping(value = "user/showcart/update", method = RequestMethod.GET)
	public String cartupdate(HttpServletRequest request, Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		Long pid = Long.parseLong(request.getParameter("pid"));
		Long maxquan = cartdao.getMaxquan(pid);
		Cart cart = new Cart();
		model.addAttribute("cart", cart);
		model.addAttribute("pid", pid);
		model.addAttribute("username", username);
		model.addAttribute("maxquan", maxquan);
		return "cartupdate";
	}

	@RequestMapping(value = "user/showcart/update", method = RequestMethod.POST)
	public String cartupdate1(@Valid @ModelAttribute("cart") Cart cart, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "cartupdate";
		} else {
			if (cart.getMaxquan() < cart.getQuantity() || cart.getQuantity() <= 0) {
				model.addAttribute("error", "Quantity Not available");
				return "cartupdate";
			}
			cartdao.updateEntry(cart);
			return "redirect:/user/showcart";
		}
	}

	@RequestMapping(value = "/user/showcart/checkout", method = RequestMethod.GET)
	public String showinvoice(HttpServletRequest request, Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		Transportentry transportentry = new Transportentry();
		model.addAttribute("transportentry", transportentry);
		model.addAttribute("username", username);
		return "checkout";
	}

	@RequestMapping(value = "/user/showcart/checkout", method = RequestMethod.POST)
	public String showinvoiceProcess(@Valid @ModelAttribute("transportentry") Transportentry transportentry,
			BindingResult result, Model model,Principal principal) {
		if (result.hasErrors()) {
			return "checkout";
		} else {
			String username = transportentry.getUsername();
			List<Cart> clist = cartdao.viewCart(username);
			for (Cart c : clist) {
				if (c.getQuantity() > cartdao.getMaxquan(c.getPid()))
					return "redirect:/user/showcart";
			}
			String name = principal.getName();
			String role=userdao.findRole(name);
			model.addAttribute("role",role);
			User user = userdao.getCustomer(username);
			model.addAttribute("cus",user);
			Long amount = cartdao.totalPrice(username);
			Integer inv_id = invoicedao.updateInvoice(username, amount);
			transportentrydao.saveEntry(transportentry, inv_id);
			List<Invoice> allent = invoicedao.updateInvoiceentry(username, amount, clist, inv_id);
			List<Invoice> allinv = invoicedao.dispInvoice(inv_id);
			model.addAttribute("allinv", allinv);
			model.addAttribute("allent", allent);
			return "showinv";
		}
	}
}