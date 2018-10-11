package minh.training.springhibernate.daos.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import minh.training.springhibernate.daos.BaseDAO;
import minh.training.springhibernate.daos.CustomerDAO;
import minh.training.springhibernate.models.Customer;
import minh.training.springhibernate.utils.MyValidationUtils;

@Transactional
public class CustomerDAOImpl extends BaseDAO implements CustomerDAO {

	public List<Customer> getListCustomer(Customer c) {
		Session session = getSession();
		Criteria crit = session.createCriteria(Customer.class);
		if (null != c) {
			if (MyValidationUtils.checkFieldNotNullWithValue(c.getName(), ""))
				crit.add(Restrictions.like("name", '%' + c.getName() + '%'));
			if (MyValidationUtils.checkFieldNotNullWithValue(c.getAddressLine(), ""))
				crit.add(Restrictions.like("addressline", '%' + c.getAddressLine() + '%'));
			if (MyValidationUtils.checkFieldNotNullWithValue(c.getEmail(), ""))
				crit.add(Restrictions.like("email", '%' + c.getEmail() + '%'));
			if (MyValidationUtils.checkFieldNotNullWithValue(c.getDateOfBirth(), new Date()))
				crit.add(Restrictions.eq("dateOfBirth", c.getDateOfBirth()));
			if (MyValidationUtils.checkFieldNotNullWithValue(c.getPhone(), ""))
				crit.add(Restrictions.like("phone", '%' + c.getPhone() + '%'));
			if (null != c.getGender())
				crit.add(Restrictions.eq("gender", c.getGender()));
		}
		return crit.list();
	}
	
	public void saveOrUpdateCustomer(Customer c){
		Session session = getSession();
		session.saveOrUpdate(c);
	}

	public Customer getCustomerById(Integer id) {
		Session session = getSession();
		return session.get(Customer.class, id);
	}
}
