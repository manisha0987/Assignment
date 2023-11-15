package com.cgc.customercontroller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.cgc.customerservice.CustomerService;
import com.cgc.entity.Customer;
@Controller
public class CustomerController {
	@Autowired
	CustomerService service;
	@RequestMapping("/customer")
	public String viewHomePage(Model model) {
		System.out.println("Hello");
		List<Customer> listCustomers=service.listAll();
		model.addAttribute("listCustomers",listCustomers);
		for(Customer p:listCustomers) {
			System.out.println("data"+p.getId()+p.getCname());
		}
		return "index";
	}
	
	@RequestMapping("/new")
	public String showNewProductPage(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "new_customer";
	}
	
	@RequestMapping(value="/save",method= RequestMethod.POST)
	public String saveProduct(@ModelAttribute("customer") Customer customer) {
		System.out.println("id "+customer.getId());
		service.save(customer);
		return "redirect:/customer";
	}
	
	@RequestMapping(value="/delete/{id}")
	public String deleteProduct(@PathVariable(name="id") Long id) {
		service.delete(id);
		return "redirect:/customer";
	}
	
	@RequestMapping("edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name="id") Long id) {
		ModelAndView mav=new ModelAndView("edit_customer");
		Customer customer=service.get(id);
		mav.addObject("customer",customer);
		return mav;
	}

}
