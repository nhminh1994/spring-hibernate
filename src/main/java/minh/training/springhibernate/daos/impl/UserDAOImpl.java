package minh.training.springhibernate.daos.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import minh.training.springhibernate.daos.BaseDAO;
import minh.training.springhibernate.daos.UserDAO;
import minh.training.springhibernate.models.User;

public class UserDAOImpl extends BaseDAO implements UserDAO {
	@Required
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public User loadUserByUsername(final String username) {
		Session session = getSession();
		Criteria crit = session.createCriteria(User.class);
		List<User> lstUser = crit.list();
		if (null != lstUser && lstUser.size() > 0) {
			return lstUser.get(0);
		} else {
			return null;
		}
	}
}
