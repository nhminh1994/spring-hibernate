package minh.training.springhibernate.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import minh.training.springhibernate.screenmodels.CustomerDetailData;
import minh.training.springhibernate.screenmodels.CustomerSearchData;
import minh.training.springhibernate.services.CustomerService;
import minh.training.springhibernate.utils.ExcelReportView;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@Autowired
	private HashMap<String, String> titleMap;

	@RequestMapping(value = { "customers" })
	public String customerlist(@ModelAttribute("customer") @Valid CustomerSearchData customer, BindingResult result,
			ModelMap modelMap) {
		if (result.hasErrors()) {
			return "/customers/customerlist";
		}
		List<CustomerDetailData> lstCustomer = customerService.getListCustomer(customer);
		modelMap.put("lstcustomer", lstCustomer);
		return "/customers/customerlist";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	@RequestMapping(value = { "create" })
	public String create(@ModelAttribute("customerdetaildata") CustomerDetailData customer, ModelMap modelMap) {
		modelMap.put("titlemap", titleMap);
		return "/customers/customerdetail";
	}

	@RequestMapping(value = { "processupdate" })
	public ModelAndView processUpdate(@ModelAttribute("customerdetaildata") @Valid CustomerDetailData customer,
			BindingResult result, ModelMap modelMap) {
		modelMap.put("titlemap", titleMap);
		if (result.hasErrors()) {
			return new ModelAndView("/customers/customerdetail");
		}
		customerService.updateOrInsertCustomer(customer);
		return new ModelAndView("redirect:/customers");
	}

	@RequestMapping(value = { "update" })
	public String processUpdate(@RequestParam(value = "customerId") Integer id, ModelMap modelMap,
			final RedirectAttributes redirectAttributes) {
		CustomerDetailData c = customerService.getCustomerDetailById(id);
		redirectAttributes.addFlashAttribute("customerdetaildata", c);
		return "redirect:create";
	}

	@RequestMapping("/report")
	public ModelAndView getExcel() {
		List<CustomerDetailData> lstCustomer = customerService.getListCustomer(new CustomerSearchData());
		return new ModelAndView(new ExcelReportView(), "customerlist", lstCustomer);
	}
}
