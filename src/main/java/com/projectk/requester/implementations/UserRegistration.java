package com.projectk.requester.implementations;

import com.projectk.entities.User;
import com.projectk.requester.implementations.services.interfaces.UserService;
import com.projectk.requester.interfaces.UserRegistrationRequester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
	public Object executeRegistration(User user) {
		return null;
	}
}
