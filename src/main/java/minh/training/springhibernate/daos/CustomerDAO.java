package minh.training.springhibernate.daos;

import java.util.List;

import minh.training.springhibernate.models.Customer;

public interface CustomerDAO {
	List<Customer> getListCustomer(Customer c);
	void saveOrUpdateCustomer(Customer c);
	Customer getCustomerById(Integer id);
}
