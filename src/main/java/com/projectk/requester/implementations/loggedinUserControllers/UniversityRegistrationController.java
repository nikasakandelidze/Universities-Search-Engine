package com.projectk.requester.implementations.loggedinUserControllers;

import com.projectk.requester.implementations.services.ServiceResult;
import com.projectk.entities.University;
import com.projectk.requester.implementations.services.interfaces.loggedInUserServices.UniversityRegistrationService;
import com.projectk.requester.interfaces.loggedinUserRequesters.UniversityRegisterRequester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UniversityRegistrationController implements UniversityRegisterRequester {
	private UniversityRegistrationService universityRegistrationService;

	@Autowired
	public UniversityRegistrationController(UniversityRegistrationService universityRegistrationService) {
		this.universityRegistrationService = universityRegistrationService;
	}

	@Override
	@GetMapping("/adduniversity")
	public Object displayUniversityRegistration() {
		return "universityAdd";
	}

	@Override
	@PostMapping("/adduniversity")
	public ModelAndView executeUniversityRegistration(@RequestParam int code,
													  @RequestParam String name,
													  @RequestParam String city,
													  @RequestParam String address,
													  @RequestParam String web,
													  @RequestParam String description,
													  @RequestParam String username) {
		ServiceResult serviceResult = universityRegistrationService.addUniversity(new University.Builder()
				.withId(code)
				.withName(name)
				.withCity(city)
				.withAddress(address)
				.withDescriptions(description)
				.withUserName(username)
				.withWebPageLink(web)
				.build());
		return new ModelAndView(serviceResult.getViewName(), serviceResult.getModelMap());
	}
}
