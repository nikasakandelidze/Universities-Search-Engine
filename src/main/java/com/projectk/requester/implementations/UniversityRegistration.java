package com.projectk.requester.implementations;

import com.projectk.entities.University;
import com.projectk.entities.User;
import com.projectk.requester.implementations.services.ServiceResult;
import com.projectk.requester.implementations.services.interfaces.UniversityService;
import com.projectk.requester.implementations.services.utils.EncryptionUtils;
import com.projectk.requester.interfaces.UniversityRequester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UniversityRegistration implements UniversityRequester {
	private UniversityService universityService;

	@Autowired
	public UniversityRegistration(UniversityService universityService) {
		this.universityService = universityService;
	}

	@Override
	@GetMapping("/universityAdd")
	public Object displayUniversityRegistration() {
		return "universityAdd";
	}

	@Override
	public ModelAndView executeUniversityRegistration(String username, String password) {
		ServiceResult serviceResult = universityService.addUniversity(new University.Builder().build());
		return new ModelAndView(serviceResult.getViewName(), serviceResult.getModelMap());
	}
}
