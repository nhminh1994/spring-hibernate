package minh.training.springhibernate.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import minh.training.springhibernate.daos.UserDAO;

public class MyUserDetailsService implements UserDetailsService {
	private UserDAO userDAO;
	@Required
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		minh.training.springhibernate.models.User user = userDAO.loadUserByUsername(username);
		if (user == null) {
			return null;
		}
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		return new User(user.getUsername(), user.getPassword(), user.getEnabled(), accountNonExpired, credentialsNonExpired,
				accountNonLocked, user.getAuthorities());
	}
}