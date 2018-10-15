package minh.training.springhibernate.services;

import java.util.List;

import minh.training.springhibernate.models.Customer;
import minh.training.springhibernate.screenmodels.CustomerDetailData;
import minh.training.springhibernate.screenmodels.CustomerSearchData;

public interface CustomerService {
	List<CustomerDetailData> getListCustomer(CustomerSearchData c);
	void updateOrInsertCustomer(CustomerDetailData c);
	CustomerDetailData getCustomerDetailById(Integer id);
	int countCustomers(CustomerSearchData c);
	List<CustomerDetailData> getListPagingCustomer(CustomerSearchData c);
	void deleteCustomers(String ids);
}
