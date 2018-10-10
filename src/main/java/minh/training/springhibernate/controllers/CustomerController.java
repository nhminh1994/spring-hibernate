package minh.training.springhibernate.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
		modelMap.put("lstcustomer", lstCustomer);
		return "customerlist";
	}
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
}
