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
import com.dbms.dao.PayLogdao;
import com.dbms.dao.Productsdao;
import com.dbms.dao.Transportentrydao;
import com.dbms.dao.Userdao;
import com.dbms.dao.Godowndao;
import com.dbms.dao.Invoicedao;
import com.dbms.dao.Transporterdao;
import com.dbms.model.Employee;
import com.dbms.model.Godown;
import com.dbms.model.Manufacturer;
import com.dbms.model.Products;
import com.dbms.model.PayLog;
import com.dbms.model.Transporter;
import com.dbms.model.User;
import com.dbms.model.Transportentry;
import com.dbms.model.Invoice;
@Controller
public class AdminController {
	
	@Autowired
	public Userdao userdao;
	@Autowired
	public Employeedao employeedao;
	@Autowired
	public Manufacturerdao manufacturerdao;
	@Autowired
	public Productsdao productsdao;
	@Autowired
	public PayLogdao paylogdao;
	@Autowired
	public Godowndao godowndao;
	@Autowired
	public Transporterdao transporterdao;
	@Autowired
	public Transportentrydao transportentrydao;
	@Autowired
	public Invoicedao invoicedao;
	
	@RequestMapping(value="admin/prodadd",method=RequestMethod.GET)
	public String prodadd1(Model model,Principal principal) {
		
		Products products = new Products();
		model.addAttribute("products", products);
		String username = principal.getName();
		String role=userdao.findRole(username);
		model.addAttribute("role",role);
		List<Manufacturer> allmanufac=manufacturerdao.dispManufac();
		model.addAttribute("allmanufac",allmanufac);
		List<Godown> allgodown=godowndao.dispGodown();
		model.addAttribute("allgodown",allgodown);
		return "prodadd";
	}
	@RequestMapping(value="admin/prodadd",method=RequestMethod.POST)
	public String prodaddProcess1(@Valid @ModelAttribute("products") Products products,BindingResult result,Model model,Principal principal) {
		if(result.hasErrors()) {
			String username = principal.getName();
			String role=userdao.findRole(username);
			model.addAttribute("role",role);
			return "prodadd";
		}
		else {
			productsdao.saveOrUpdateProducts(products);
			return "redirect:/admin";
		}
	}
	@RequestMapping(value="admin/showprod")
	public String dispProducts1(Model model, Principal principal) {
		
		List<Products> allprod = productsdao.dispProducts();
		String username = principal.getName();
		String role=userdao.findRole(username);
		model.addAttribute("role",role);
		model.addAttribute("allprod",allprod);
		
		return "showprod";
		
	}
	@RequestMapping(value="admin/showprod/delete/{name}")
	public String deleteprod(@PathVariable("name") Long name) {
		
		productsdao.delete(name);
		return "redirect:/admin/showprod";
		
	}
	@RequestMapping(value="admin/showprod/update",method=RequestMethod.GET)
	public String produpdate(HttpServletRequest request, Model model,Principal principal) {
		Long pid=Long.parseLong(request.getParameter("name"));
		Products products = productsdao.getProducts(pid);
		model.addAttribute("products", products);
		model.addAttribute("pid",pid);
		String username = principal.getName();
		String role=userdao.findRole(username);
		model.addAttribute("role",role);
		List<Manufacturer> allmanufac=manufacturerdao.dispManufac();
		model.addAttribute("allmanufac",allmanufac);
		List<Godown> allgodown=godowndao.dispGodown();
		model.addAttribute("allgodown",allgodown);
		return "produpdate";
	}
	@RequestMapping(value="admin/showprod/update",method=RequestMethod.POST)
	public String produpdate1(@Valid @ModelAttribute("products") Products products,BindingResult result,Model model,Principal principal) {
		if(result.hasErrors()) {
			String username = principal.getName();
			String role=userdao.findRole(username);
			model.addAttribute("role",role);
			return "produpdate";
		}
		else {
			productsdao.produpdate(products);
			return "redirect:/admin";
		}
	}
	
	
	
	@RequestMapping(value="admin/empregister",method=RequestMethod.GET)
	public String empregister(Model model) {
		
		Employee employee = new Employee();
		model.addAttribute("employee", employee);

		return "empregister";
	}
	@RequestMapping(value="admin/empregister",method=RequestMethod.POST)
	public String empregisterProcess(@Valid @ModelAttribute("employee") Employee employee,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "empregister";
		}
		else {
			if(!employee.getPassword().equals(employee.getMpassword())) {
				model.addAttribute("error","passwords dont match");
				return "empregister";
			}
			if(employeedao.getEmployeeUser(employee.getUsername())!=null) {
				model.addAttribute("error", "username exists");
				return "empregister";
			}
			employeedao.saveOrUpdate(employee);
			return "redirect:/admin";
		}
	}
	@RequestMapping(value="admin/showemp")
	public String showEmployee(Model model) {
		
		List<Employee> allemp = employeedao.dispEmployee();
		model.addAttribute("allemp",allemp);
		
		return "showemp";
		
	}
	@RequestMapping(value="admin/showemp/delete/{username}")
	public String deleteemp(@PathVariable("username") String username) {
		
		employeedao.delete(username);
		return "redirect:/admin/showemp";
		
	}
	@RequestMapping(value="admin/showemp/update",method=RequestMethod.GET)
	public String empupdate1(HttpServletRequest request, Model model) {
		String username=request.getParameter("user");
		Employee employee = employeedao.getEmployee(username);
		model.addAttribute("employee", employee);
		model.addAttribute("username",username);

		return "empupdate";
	}
	@RequestMapping(value="admin/showemp/update",method=RequestMethod.POST)
	public String empupdate(@Valid @ModelAttribute("employee") Employee employee,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "empupdate";
		}
		else {
			if(!employee.getPassword().equals(employee.getMpassword())) {
				model.addAttribute("error", "passwords don't match");
				return "empupdate";
			}
			employeedao.empupdate(employee);
			return "redirect:/admin";
		}
	}
	
	
	
	
	@RequestMapping(value="admin/manregister",method=RequestMethod.GET)
	public String manregister(Model model) {
		
		Manufacturer manufacturer = new Manufacturer();
		model.addAttribute("manufacturer", manufacturer);

		return "manregister";
	}
	@RequestMapping(value="admin/manregister",method=RequestMethod.POST)
	public String manregisterProcess(@Valid @ModelAttribute("manufacturer") Manufacturer manufacturer,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "manregister";
		}
		else {
			manufacturerdao.saveOrUpdateManufacturer(manufacturer);
			return "redirect:/admin";
		}
	}
	@RequestMapping(value="admin/showmanufac")
	public String showManufac(Model model) {
		
		List<Manufacturer> allmanufac = manufacturerdao.dispManufac();
		model.addAttribute("allmanufac",allmanufac);
		
		return "showmanufac";
		
	}
	@RequestMapping(value="admin/showmanufac/delete/{name}")
	public String deletemanufac(@PathVariable("name") String name) {
		
		manufacturerdao.delete(name);
		return "redirect:/admin/showmanufac";
		
	}
	@RequestMapping(value="admin/showmanufac/update",method=RequestMethod.GET)
	public String manufacupdate(HttpServletRequest request, Model model) {
		String name=request.getParameter("user");
		Manufacturer manufacturer = manufacturerdao.getManufacturer(name);
		model.addAttribute("manufacturer", manufacturer);
		model.addAttribute("name",name);

		return "manufacupdate";
	}
	@RequestMapping(value="admin/showmanufac/update",method=RequestMethod.POST)
	public String manufacupdate1(@Valid @ModelAttribute("manufacturer") Manufacturer manufacturer,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "manufacupdate";
		}
		else {
			manufacturerdao.manufacupdate(manufacturer);
			return "redirect:/admin";
		}
	}
	
	
	@RequestMapping(value="admin/payemp",method=RequestMethod.GET)
	public String emppay(Model model) {
		
		PayLog paylog = new PayLog();
		model.addAttribute("paylog", paylog);
		List<Employee> allemp=employeedao.dispEmployee();
		model.addAttribute("allemp",allemp);
		return "payemp";
	}
	@RequestMapping(value="admin/payemp",method=RequestMethod.POST)
	public String emppayProcess(@Valid @ModelAttribute("paylog") PayLog paylog,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "redirect:/admin/payemp";
		}
		else {
			if(paylog.getAmount()<=0) {
				model.addAttribute("error", "payment must be positive");
				return "reirect:/admin/payemp";
			}
			paylogdao.updateELog(paylog);
			return "redirect:/admin";
		}
	}
	
	@RequestMapping(value="admin/payman",method=RequestMethod.GET)
	public String manpay(HttpServletRequest request, Model model) {
		
		PayLog paylog = new PayLog();
		model.addAttribute("paylog", paylog);
		List<Manufacturer> allman=manufacturerdao.dispManufac();
		model.addAttribute("allman",allman);

		return "payman";
	}
	@RequestMapping(value="admin/payman",method=RequestMethod.POST)
	public String manpayProcess(@Valid @ModelAttribute("paylog") PayLog paylog,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "redirect:/admin/payman";
		}
		else {
			if(paylog.getAmount()<=0) {
				model.addAttribute("error", "payment must be positive");
				return "redirect:/admin/payman";
			}
			paylogdao.updateMLog(paylog);
			return "redirect:/admin";
		}
	}
	
	@RequestMapping(value="admin/showlog")
	public String showpayLog(Model model) {
		
		List<PayLog> allpay = paylogdao.displog();
		model.addAttribute("allpay",allpay);
		
		return "showlog";
		
	}
	
	@RequestMapping(value="admin/godownadd",method=RequestMethod.GET)
	public String addgodown(Model model) {
		
		Godown godown = new Godown();
		model.addAttribute("godown", godown);
		return "godownadd";
	}
	
	@RequestMapping(value="admin/godownadd",method=RequestMethod.POST)
	public String addgodownProcess(@Valid @ModelAttribute("godown") Godown godown,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "redirect:/admin/godownadd";
		}
		else {
			godowndao.saveGodown(godown);
			return "redirect:/admin";
		}
	}
	
	@RequestMapping(value="admin/dispgodown")
	public String showGodown(Model model) {
		List<Godown> allgodown=godowndao.dispGodown();
		model.addAttribute("allgodown",allgodown);
		return "dispgodown";
	}
	
	@RequestMapping(value="/admin/dispgodown/delete/{godown}")
	public String delgodown(@PathVariable("godown") Long godown) {
		godowndao.delete(godown);
		return "redirect:/admin/dispgodown";
	}
	
	@RequestMapping(value="/admin/dispgodown/update",method=RequestMethod.GET)
	public String updategod(HttpServletRequest request, Model model) {
		Long gid = Long.parseLong(request.getParameter("godown"));
		Godown godown = godowndao.getGodown(gid);
		model.addAttribute("godown", godown);
		model.addAttribute("gid", gid);
		return "godownupdate";
	}
	
	@RequestMapping(value="/admin/dispgodown/update",method=RequestMethod.POST)
	public String updaetgodProcess(@Valid @ModelAttribute("godown") Godown godown,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "godownupdate";
		}
		else {
			godowndao.updateGodown(godown);
			return "redirect:/admin";
		}
	}
	
	@RequestMapping(value="admin/transadd",method=RequestMethod.GET)
	public String transadd(Model model) {
		
		Transporter transporter = new Transporter();
		model.addAttribute("transporter", transporter);
		return "transadd";
	}
	@RequestMapping(value="admin/transadd",method=RequestMethod.POST)
	public String transaddProcess1(@Valid @ModelAttribute("transporter") Transporter transporter,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "transadd";
		}
		else {
			transporterdao.saveTransporter(transporter);
			return "redirect:/admin";
		}
	}
	
	@RequestMapping(value="admin/disptrans")
	public String disptrans(Model model, Principal principal) {
		
		List<Transporter> alltrans = transporterdao.dispTrans();
		model.addAttribute("alltrans",alltrans);
		
		return "disptrans";
		
	}
	@RequestMapping(value="admin/disptrans/delete/{tid}")
	public String deletetrans(@PathVariable("tid") Long tid) {
		
		transporterdao.delete(tid);
		return "redirect:/admin/disptrans";
		
	}
	
	@RequestMapping(value="admin/disptrans/update",method=RequestMethod.GET)
	public String transdupdate(HttpServletRequest request, Model model) {
		Long tid = Long.parseLong(request.getParameter("trans"));
		Transporter transporter = transporterdao.getTransporter(tid);
		model.addAttribute("transporter", transporter);
		model.addAttribute("tid", tid);
		return "transupdate";
	}
	@RequestMapping(value="admin/disptrans/update",method=RequestMethod.POST)
	public String transupdate1(@Valid @ModelAttribute("transporter") Transporter transporter,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "transupdate";
		}
		else {
			transporterdao.update(transporter);
			return "redirect:/admin";
		}
	}
	
	@RequestMapping(value="admin/disptransnot")
	public String disptransnot(Model model, Principal principal) {
		
		List<Transportentry> allentry = transportentrydao.dispEntry("NO");
		model.addAttribute("allentry",allentry);
		String username = principal.getName();
		String role=userdao.findRole(username);
		model.addAttribute("role",role);
		return "disptransnot";
	}
	
	@RequestMapping(value="admin/disptransnot/setdue",method=RequestMethod.GET)
	public String setdue(HttpServletRequest request, Model model,Principal principal) {
		Transportentry transportentry = new Transportentry();
		Long inv_id = Long.parseLong(request.getParameter("inv_id"));
		model.addAttribute("transportentry", transportentry);
		model.addAttribute("inv_id", inv_id);
		List<Transporter> alltrans = transporterdao.dispTrans();
		String username = principal.getName();
		String role=userdao.findRole(username);
		model.addAttribute("role",role);
		model.addAttribute("alltrans",alltrans);
		return "setdue";
	}
	@RequestMapping(value="admin/disptransnot/setdue",method=RequestMethod.POST)
	public String setdueProcess(@Valid @ModelAttribute("transportentry") Transportentry transportentry,BindingResult result,Model model,Principal principal) {
		if(result.hasErrors()) {
			String username = principal.getName();
			String role=userdao.findRole(username);
			model.addAttribute("role",role);
			return "setdue";
		}
		else {
			transportentrydao.updateEntry(transportentry,"YES");
			return "redirect:/admin";
		}
	}
	
	@RequestMapping(value="admin/disptransyes")
	public String disptransyes(Model model,Principal principal) {
		String username = principal.getName();
		String role=userdao.findRole(username);
		model.addAttribute("role",role);
		List<Transportentry> allentry = transportentrydao.dispEntry("YES");
		model.addAttribute("allentry",allentry);
		return "disptransyes";
	}
	
	@RequestMapping(value="admin/dispinvoice")
	public String dispinvoices(Model model) {
		List<Invoice> allinv = invoicedao.dispAllinv();
		model.addAttribute("allinv",allinv);
		return "dispinvoice";
	}
	
	@RequestMapping(value="admin/dispinvoice/invoicedetail")
	public String dispinvoicedet(Model model, HttpServletRequest request, Principal principal) {
		Integer inv_id=Integer.parseInt(request.getParameter("id"));
		List<Invoice> allinve = invoicedao.dispInvoice(inv_id);
		model.addAttribute("allinv", allinve);
		String username=invoicedao.findUser(inv_id);
		List<User> allusr=userdao.dispuser(username);
		List<Invoice> allinvent= invoicedao.dispEntry(inv_id);
		model.addAttribute("allent", allinvent);
		String name = principal.getName();
		String role=userdao.findRole(name);
		model.addAttribute("role",role);
		return "showinv";
	}
	
}
