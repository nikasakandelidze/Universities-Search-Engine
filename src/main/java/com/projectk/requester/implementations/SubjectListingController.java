package com.projectk.requester.implementations;

import com.projectk.entities.searchEntities.SearchSubject;
import com.projectk.requester.implementations.services.ServiceResult;
import com.projectk.requester.implementations.services.interfaces.loggedInUserServices.SubjectService;
import com.projectk.requester.interfaces.SubjectListingRequester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

public class SubjectListingController implements SubjectListingRequester {
	private SubjectService subjectService;

	@Autowired
	public SubjectListingController(SubjectService subjectService) {
		this.subjectService = subjectService;
	}

	@Override
	@GetMapping(path = "/faculty/{facultyId}")
	public Object displaySubjectListing(String facultyId) {
		ServiceResult serviceResult = subjectService.filterSubjects(SearchSubject.selectByFacultyId(facultyId));
		return new ModelAndView(serviceResult.getViewName(), serviceResult.getModelMap());
	}
}
