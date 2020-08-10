package com.projectk.requester.implementations.loggedinUser;

import com.projectk.entities.ServiceResult;
import com.projectk.entities.University;
import com.projectk.requester.interfaces.loggedinUserRequesters.UniversityUpdateRequester;
import com.projectk.services.interfaces.loggedInUserServices.UniversityService;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UniversityUpdateController implements UniversityUpdateRequester {
	private UniversityService universityService;

	@Autowired
	public UniversityUpdateController(UniversityService universityService) {
		this.universityService = universityService;
	}

	@Override
	@GetMapping("/universityUpdate/{universityId}")
	public Object displayUniversityUpdate(@PathVariable String universityId) {
		ServiceResult result = universityService.findById(universityId);
		return new ModelAndView(result.getViewName(), result.getModelMap());
	}

	@Override
	@PostMapping("/universityUpdate")
	public Object executeUniversityUpdate(University university) {
		ServiceResult result = universityService.updateUniversity(university);
		return new ModelAndView(result.getViewName(), result.getModelMap());
	}
}

