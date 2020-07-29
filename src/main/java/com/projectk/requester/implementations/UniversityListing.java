package com.projectk.requester.implementations;

import com.projectk.entities.University;
import com.projectk.entities.searchEntities.SearchUniversity;
import com.projectk.requester.implementations.services.ServiceResult;
import com.projectk.requester.implementations.services.interfaces.UniversityService;
import com.projectk.requester.interfaces.UniversityListingRequester;
import com.sun.tools.javac.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UniversityListing implements UniversityListingRequester {
	private UniversityService universityService;

	@Autowired
	public UniversityListing(UniversityService universityService) {
		this.universityService = universityService;
	}

	@Override
	@GetMapping("/universityListing")
	public ModelAndView displayUniversityListing() {
		ModelAndView model = new ModelAndView("/universityListing");
		//todo: get this data from service
		University u = new University();
		u.setUniversityName("aaaa");
		u.setDescriptions("magaria, magaria,magaria,magaria,magaria,magaria,magaria,magaria,");
		University u2 = new University();
		u2.setUniversityName("bbbbbbb");
		u2.setDescriptions("dsakjnda, dsakjnda, dsakjnda, dsakjnda, dsakjnda, dsakjnda");
		model.addObject("allUniversities", List.of(u, u2));

		ServiceResult serviceResult = universityService.filterUniversities(new SearchUniversity.Builder()
				.universityName(null)
				.city(null)
				.faculty(null)
				.build());

		return new ModelAndView(serviceResult.getViewName(), serviceResult.getModelMap());
	}
}
