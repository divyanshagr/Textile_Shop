package com.dbms;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dbms.dao.Employeedao;
import com.dbms.dao.Manufacturerdao;
import com.dbms.dao.Productsdao;
import com.dbms.dao.Transportentrydao;
import com.dbms.dao.Userdao;
import com.dbms.dao.Godowndao;
import com.dbms.dao.Transporterdao;
import com.dbms.model.Godown;
import com.dbms.model.Manufacturer;
import com.dbms.model.Products;
import com.dbms.model.Transportentry;
import com.dbms.model.Transporter;


@Controller
public class EmployeeController {
	
	@Autowired
	public Userdao userdao;
	@Autowired
	public Employeedao employeedao;
	@Autowired
	public Manufacturerdao manufacturerdao;
	@Autowired
	public Productsdao productsdao;
	@Autowired
	public Godowndao godowndao;
	@Autowired
	public Transporterdao transporterdao;
	@Autowired
	public Transportentrydao transportentrydao;
	
	
	
	
	@RequestMapping(value="empl/prodadd",method=RequestMethod.GET)
	public String prodadd(Model model,Principal principal) {
		
		Products products = new Products();
		model.addAttribute("products", products);
		List<Manufacturer> allmanufac=manufacturerdao.dispManufac();
		model.addAttribute("allmanufac",allmanufac);
		List<Godown> allgodown=godowndao.dispGodown();
		model.addAttribute("allgodown",allgodown);
		String username = principal.getName();
		String role=userdao.findRole(username);
		model.addAttribute("role",role);
		return "prodadd";
	}
	@RequestMapping(value="empl/prodadd",method=RequestMethod.POST)
	public String prodaddProcess(@Valid @ModelAttribute("products") Products products,BindingResult result,Model model,Principal principal) {
		if(result.hasErrors()) {
			String username = principal.getName();
			String role=userdao.findRole(username);
			model.addAttribute("role",role);
			return "prodadd";
		}
		else {
			productsdao.saveOrUpdateProducts(products);
			return "redirect:/empl";
		}
	}
	@RequestMapping(value="empl/showprod")
	public String dispProducts(Model model,Principal principal) {
		
		List<Products> allprod = productsdao.dispProducts();
		model.addAttribute("allprod",allprod);
		String username = principal.getName();
		String role=userdao.findRole(username);
		model.addAttribute("role",role);
		return "showprod";
		
	}
	@RequestMapping(value="empl/showprod/delete/{name}")
	public String deleteprod2(@PathVariable("name") Long name) {
		
		productsdao.delete(name);
		return "redirect:/empl";
		
	}
	@RequestMapping(value="empl/showprod/update",method=RequestMethod.GET)
	public String produpdate2(HttpServletRequest request, Model model,Principal principal) {
		Long pid=Long.parseLong(request.getParameter("name"));
		Products products = productsdao.getProducts(pid);
		model.addAttribute("products", products);
		model.addAttribute("pid",pid);
		List<Manufacturer> allmanufac=manufacturerdao.dispManufac();
		model.addAttribute("allmanufac",allmanufac);
		List<Godown> allgodown=godowndao.dispGodown();
		model.addAttribute("allgodown",allgodown);
		String username = principal.getName();
		String role=userdao.findRole(username);
		model.addAttribute("role",role);
		return "produpdate";
	}
	@RequestMapping(value="empl/showprod/update",method=RequestMethod.POST)
	public String produpdate3(@Valid @ModelAttribute("products") Products products,BindingResult result,Model model,Principal principal) {
		if(result.hasErrors()) {
			String username = principal.getName();
			String role=userdao.findRole(username);
			model.addAttribute("role",role);
			return "produpdate";
		}
		else {
			productsdao.produpdate(products);
			return "empl";
		}
	}
	
	@RequestMapping(value="empl/disptransnot")
	public String disptransnot(Model model,Principal principal) {
		String username = principal.getName();
		String role=userdao.findRole(username);
		model.addAttribute("role",role);
		List<Transportentry> allentry = transportentrydao.dispEntry("NO");
		model.addAttribute("allentry",allentry);
		return "disptransnot";
	}
	
	@RequestMapping(value="empl/disptransnot/setdue",method=RequestMethod.GET)
	public String setdue(HttpServletRequest request, Model model,Principal principal) {
		Transportentry transportentry = new Transportentry();
		Long inv_id = Long.parseLong(request.getParameter("inv_id"));
		model.addAttribute("transportentry", transportentry);
		model.addAttribute("inv_id", inv_id);
		List<Transporter> alltrans = transporterdao.dispTrans();
		model.addAttribute("alltrans",alltrans);
		String username = principal.getName();
		String role=userdao.findRole(username);
		model.addAttribute("role",role);
		return "setdue";
	}
	@RequestMapping(value="empl/disptransnot/setdue",method=RequestMethod.POST)
	public String setdueProcess(@Valid @ModelAttribute("transportentry") Transportentry transportentry,BindingResult result,Model model,Principal principal) {
		if(result.hasErrors()) {
			String username = principal.getName();
			String role=userdao.findRole(username);
			model.addAttribute("role",role);
			return "setdue";
		}
		else {
			transportentrydao.updateEntry(transportentry,"YES");
			return "empl";
		}
	}
	
	@RequestMapping(value="empl/disptransyes")
	public String disptransyes(Model model,Principal principal) {
		String username = principal.getName();
		String role=userdao.findRole(username);
		model.addAttribute("role",role);
		List<Transportentry> allentry = transportentrydao.dispEntry("YES");
		model.addAttribute("allentry",allentry);
		return "disptransyes";
	}
}
