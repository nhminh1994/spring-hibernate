package minh.training.springhibernate.security;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class CustomDaoAuthenticationProvider extends DaoAuthenticationProvider {
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		if (null == authentication.getCredentials())
			return null;
		String name = authentication.getName();
		String password = authentication.getCredentials().toString();
		StringBuilder error = new StringBuilder();
		if (name.trim().isEmpty()) {
			error.append("name cannot be blank");
			error.append("\n");
		}
		if (password.length() < 6) {
			error.append("password must >= 6");
		}
		String message = error.toString();
		if (!message.isEmpty()) {
			throw new AuthenticationException(message) {
				private static final long serialVersionUID = 1L;
			};
		}
		return super.authenticate(authentication);

	}
}
