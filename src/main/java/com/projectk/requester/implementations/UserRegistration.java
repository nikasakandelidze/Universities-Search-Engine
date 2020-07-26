package com.projectk.requester.implementations;

import com.projectk.entities.User;
import com.projectk.requester.implementations.services.ServiceResult;
import com.projectk.requester.implementations.services.interfaces.UserService;
import com.projectk.requester.interfaces.UserRegistrationRequester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserRegistration implements UserRegistrationRequester {
	private UserService userService;
	@Autowired
	public UserRegistration(UserService userService){
		this.userService = userService;
	}

	@Override
	@GetMapping("/register")
	public Object displayRegistration() {
		return "register";
	}

	@Override
	@PostMapping("/register")
	public ModelAndView executeRegistration(@RequestParam String code,
											@RequestParam String username,
											@RequestParam String password) {
		ServiceResult serviceResult = userService.addUser(new User("da", "dada"));
		return new ModelAndView(serviceResult.getViewName(), serviceResult.getModelMap());
	}
}
