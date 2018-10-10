package minh.training.springhibernate.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import minh.training.springhibernate.daos.UserDAO;
import minh.training.springhibernate.models.Customer;
import minh.training.springhibernate.services.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = { "/customers", "/" })
	public String customerlist(@ModelAttribute("customer") Customer customer, ModelMap modelMap) {
		List<Customer> lstCustomer = customerService.getListCustomer(customer);
		return "customerlist";
	}
}
