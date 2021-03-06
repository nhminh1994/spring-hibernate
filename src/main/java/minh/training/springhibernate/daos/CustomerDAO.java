package minh.training.springhibernate.daos;

import java.util.List;

import org.hibernate.criterion.Order;

import minh.training.springhibernate.models.Customer;

public interface CustomerDAO {
	List<Customer> getListCustomer(Customer c);
	void saveOrUpdateCustomer(Customer c);
	Customer getCustomerById(Integer id);
	Long countCustomers(Customer c);
	List<Customer> getListPagingCustomer(Customer c, int start, int end, Order order);
	void deleteCustomers(List<Integer> ids);
}
