package minh.training.springhibernate.daos;

import minh.training.springhibernate.models.User;

public interface UserDAO {
	public User loadUserByUsername(final String username);
}
