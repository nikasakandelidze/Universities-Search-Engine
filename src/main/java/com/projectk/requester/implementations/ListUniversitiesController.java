package com.projectk.requester.implementations;

import com.projectk.entities.University;
import com.projectk.requester.implementations.services.interfaces.loggedInUserServices.UniversityRegistrationService;
import com.projectk.requester.interfaces.UniversityListingRequester;
import com.sun.tools.javac.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ListUniversitiesController implements UniversityListingRequester {
	private UniversityRegistrationService universityRegistrationService;

	@Autowired
	public ListUniversitiesController(UniversityRegistrationService universityRegistrationService) {
		this.universityRegistrationService = universityRegistrationService;
	}

	@Override
	@GetMapping("/universityListing")
	public ModelAndView displayUniversityListing() {
		ModelAndView model = new ModelAndView("universityListing");
		//todo: get this data from service
		University u = new University();
		u.setUniversityName("aaaa");
		u.setDescriptions("magaria, magaria,magaria,magaria,magaria,magaria,magaria,magaria,");
		University u2 = new University();
		u2.setUniversityName("bbbbbbb");
		u2.setDescriptions("dsakjnda, dsakjnda, dsakjnda, dsakjnda, dsakjnda, dsakjnda");
		University u3 = new University();
		u3.setUniversityName("aaaa");
		u3.setDescriptions("magaria, magaria,magaria,magaria,magaria,magaria,magaria,magaria,");
		University u4 = new University();
		u4.setUniversityName("bbbbbbb");
		u4.setDescriptions("dsakjnda, dsakjnda, dsakjnda, dsakjnda, dsakjnda, dsakjnda");
		University u5 = new University();
		u5.setUniversityName("aaaa");
		u5.setDescriptions("magaria, magaria,magaria,magaria,magaria,magaria,magaria,magaria,");
		University u6 = new University();
		u6.setUniversityName("bbbbbbb");
		u6.setDescriptions("dsakjnda, dsakjnda, dsakjnda, dsakjnda, dsakjnda, dsakjnda");
		University u7 = new University();
		u7.setUniversityName("aaaa");
		u7.setDescriptions("magaria, magaria,magaria,magaria,magaria,magaria,magaria,magaria,");
		University u8 = new University();
		u8.setUniversityName("bbbbbbb");
		u8.setDescriptions("dsakjnda, dsakjnda, dsakjnda, dsakjnda, dsakjnda, dsakjnda");
		model.addObject("allUniversities", List.of(u, u2, u3, u4, u5, u6, u7, u8));
		return model;
//		ServiceResult serviceResult = universityService.filterUniversities(new SearchUniversity.Builder()
//				.universityName(null)
//				.city(null)
//				.faculty(null)
//				.build());
//
//		return new ModelAndView(serviceResult.getViewName(), serviceResult.getModelMap());
	}
}
