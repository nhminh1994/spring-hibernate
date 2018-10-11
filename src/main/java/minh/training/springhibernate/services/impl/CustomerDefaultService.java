package minh.training.springhibernate.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Required;

import minh.training.springhibernate.daos.CustomerDAO;
import minh.training.springhibernate.models.Customer;
import minh.training.springhibernate.screenmodels.CustomerDetailData;
import minh.training.springhibernate.screenmodels.CustomerSearchData;
import minh.training.springhibernate.services.CustomerService;

public class CustomerDefaultService implements CustomerService {

	private CustomerDAO customerDAO;

	@Required
	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	public List<CustomerDetailData> getListCustomer(CustomerSearchData c) {
		Customer customer = new Customer(null, c.getName(), c.getDateOfBirth(), c.getPhone(), c.getEmail(),
				c.getGender(), null, null);
		List<Customer> lstCustomer = customerDAO.getListCustomer(customer);
		List<CustomerDetailData> lstCDD = new ArrayList<CustomerDetailData>();
		for (Customer cus : lstCustomer) {
			CustomerDetailData cdd = new CustomerDetailData(cus.getId(), cus.getName(), cus.getDateOfBirth(),
					cus.getPhone(), cus.getEmail(), cus.getGender(), cus.getAddressLine(), cus.getTitle());
			lstCDD.add(cdd);
		}
		return lstCDD;
	}

	public void updateOrInsertCustomer(CustomerDetailData c) {
		Customer customer = new Customer(c.getId(), c.getName(), c.getDateOfBirth(), c.getPhone(), c.getEmail(),
				c.getGender(), c.getAddressLine(), c.getTitle());
		customerDAO.saveOrUpdateCustomer(customer);
	}

	public CustomerDetailData getCustomerDetailById(Integer id) {
		Customer c = customerDAO.getCustomerById(id);
		CustomerDetailData cd = new CustomerDetailData(c.getId(), c.getName(), c.getDateOfBirth(), c.getPhone(),
				c.getEmail(), c.getGender(), c.getAddressLine(), c.getTitle());
		return cd;
	}

}
