package com.in28minutes;

import com.in28minutes.LoginValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@Autowired
	LoginValidationService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String submit(@RequestParam String name, @RequestParam String password, ModelMap model){
		if (service.validateUsernameAndPassword(name, password)) {
			model.addAttribute("name", name);
			model.addAttribute("password", password);
			return "welcome";
		}

		model.addAttribute("errorMessage", "Invalid Credentials");
		return "login";
	}
}
