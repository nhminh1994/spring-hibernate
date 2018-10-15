package minh.training.springhibernate.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import minh.training.springhibernate.daos.UserDAO;
import minh.training.springhibernate.screenmodels.LoginData;

@Controller
public class UserController {
	@Autowired
	private ApplicationContext applicationContext;

	@RequestMapping(value = { "/login" })
	public String login(
			@RequestParam(value = "error", required = false) final String error, 
			HttpServletRequest request, final Model model) {
		Object message = request.getAttribute("SPRING_SECURITY_LAST_EXCEPTION ");
		if (error != null) {
			model.addAttribute("message", "Login Failed!");
		}
		return "login";
	}

	@RequestMapping("/admin")
	public String admin() {
		return "admin";
	}

	@RequestMapping("/user")
	public String user() {
		return "user";
	}

	@RequestMapping("/logout")
	public String logout(final Model model) {
		model.addAttribute("message", "Logged out!");
		return "login";
	}
}
