package minh.training.springhibernate.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;

import minh.training.springhibernate.daos.CustomerDAO;
import minh.training.springhibernate.models.Customer;
import minh.training.springhibernate.services.CustomerService;

public class CustomerDefaultService implements CustomerService {

	private CustomerDAO customerDAO;

	@Required
	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	public List<Customer> getListCustomer(Customer c) {

		return customerDAO.getListCustomer(c);
	}

}
