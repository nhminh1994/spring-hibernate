package minh.training.springhibernate.services;

import java.util.List;

import minh.training.springhibernate.models.Customer;

public interface CustomerService {
	List<Customer> getListCustomer(Customer c);
}
