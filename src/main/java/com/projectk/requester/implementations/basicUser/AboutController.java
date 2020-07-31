package com.projectk.requester.implementations.basicUser;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AboutController {
	@GetMapping("/about")
	String getView(){
		return "about";
	}
}
