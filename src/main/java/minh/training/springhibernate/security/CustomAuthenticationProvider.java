package minh.training.springhibernate.security;

import java.util.ArrayList;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CustomAuthenticationProvider implements AuthenticationProvider {
	public static void main(String[] argv){
		BCryptPasswordEncoder b = new BCryptPasswordEncoder();
		System.out.println(b.encode("ahri1234"));
	}	
	public Authentication authenticate(Authentication authentication)throws AuthenticationException {
        if (null == authentication.getCredentials() || authentication.isAuthenticated())
        	return null;
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        if (password.length() >= 7) {
            return new UsernamePasswordAuthenticationToken(
              name, password);
        } else {
        	throw new AuthenticationException("password must >= 7") {
				private static final long serialVersionUID = 1L;
			};
        }
    }
 
    public boolean supports(Class<?> authentication) {
        return authentication.equals(
          UsernamePasswordAuthenticationToken.class);
    }

}
