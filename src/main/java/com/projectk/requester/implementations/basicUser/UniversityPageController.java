package com.projectk.requester.implementations.basicUser;

import com.projectk.entities.ServiceResult;
import com.projectk.services.interfaces.UniversityFacultyService;
import com.projectk.requester.interfaces.basicUser.UniversityPageRequester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UniversityPageController implements UniversityPageRequester {
	private UniversityFacultyService universityFacultyService;

	@Autowired
	public UniversityPageController(UniversityFacultyService universityFacultyService) {
		this.universityFacultyService = universityFacultyService;
	}

	@Override
	@GetMapping(path = "/universityPage/{universityId}")
	public Object displayUniversityPage(@PathVariable("universityId") int universityId) {
		ServiceResult serviceResult = universityFacultyService.getUniversity(universityId);
		return new ModelAndView(serviceResult.getViewName(), serviceResult.getModelMap());
	}
}
