package com.projectk.requester.implementations;

import com.projectk.requester.implementations.services.ServiceResult;
import com.projectk.entities.University;
import com.projectk.requester.implementations.services.interfaces.UniversityService;
import com.projectk.requester.interfaces.UniversityRequester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UniversityRegistration implements UniversityRequester {
	private UniversityService universityService;

	@Autowired
	public UniversityRegistration(UniversityService universityService) {
		this.universityService = universityService;
	}

	@Override
	@GetMapping("/user/adduniversity")
	public Object displayUniversityRegistration() {
		return "universityAdd";
	}

	@Override
	@PostMapping("/user/adduniversity")
	public ModelAndView executeUniversityRegistration(@RequestParam int code,
													  @RequestParam String name,
													  @RequestParam String city,
													  @RequestParam String address,
													  @RequestParam String web,
													  @RequestParam String description,
													  @RequestParam String username) {
		ServiceResult serviceResult = universityService.addUniversity(new University.Builder()
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
