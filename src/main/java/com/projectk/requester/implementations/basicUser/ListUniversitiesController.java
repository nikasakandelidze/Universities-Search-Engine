package com.projectk.requester.implementations.basicUser;

import com.projectk.entities.searchEntities.SearchUniversity;
import com.projectk.entities.ServiceResult;
import com.projectk.services.interfaces.loggedInUserServices.UniversityService;
import com.projectk.requester.interfaces.basicUser.UniversityListingRequester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ListUniversitiesController implements UniversityListingRequester {
	private UniversityService universityService;

	@Autowired
	public ListUniversitiesController(UniversityService universityService) {
		this.universityService = universityService;
	}

	@Override
	@GetMapping("/universityListing/{universityName}")
	public ModelAndView displayUniversityListing(@PathVariable String universityName) {
		ServiceResult serviceResult = universityService.filterUniversities(getSearchUniversity(universityName));
		return new ModelAndView(serviceResult.getViewName(), serviceResult.getModelMap());
	}

	private SearchUniversity getSearchUniversity(String universityName) {
		return SearchUniversity.selectByName(universityName.equals("null") ? null : universityName);
	}
}
