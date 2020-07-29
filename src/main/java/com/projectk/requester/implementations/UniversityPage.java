package com.projectk.requester.implementations;

import com.projectk.entities.ServiceResult;
import com.projectk.entities.University;
import com.projectk.entities.searchEntities.SearchUniversity;
import com.projectk.requester.implementations.services.interfaces.UniversityService;
import com.projectk.requester.interfaces.UniversityPageRequester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UniversityPage implements UniversityPageRequester {
	private UniversityService universityService;

	@Autowired
	public UniversityPage(UniversityService universityService) {
		this.universityService = universityService;
	}

	@Override
	@GetMapping(path = "/universityPage/{universityId}")
	public Object displayUniversityPage(@PathVariable("universityId") int universityId) {
		ServiceResult serviceResult = universityService.filterUniversities(new SearchUniversity.Builder()
				.universityId(universityId)
				.build());
		return new ModelAndView(serviceResult.getViewName(), serviceResult.getModelMap());
	}
}