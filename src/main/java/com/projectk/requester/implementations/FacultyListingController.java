package com.projectk.requester.implementations;

import com.projectk.entities.enums.FacultyCategory;
import com.projectk.entities.searchEntities.SearchFaculty;
import com.projectk.requester.implementations.services.ServiceResult;
import com.projectk.requester.implementations.services.interfaces.FacultyService;
import com.projectk.requester.interfaces.FacultyListingRequester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FacultyListingController implements FacultyListingRequester {
	private FacultyService facultyService;

	@Autowired
	public FacultyListingController(FacultyService facultyService) {
		this.facultyService = facultyService;
	}

	@Override
	@GetMapping("/facultyListing/{facultyCategory}")
	public Object displayFacultyListing(@PathVariable String facultyCategory) {
		ServiceResult faculties = facultyService.filterFaculties(SearchFaculty.selectFacultyWithCategory(FacultyCategory.valueOf(facultyCategory)));
		return new ModelAndView(faculties.getViewName(), faculties.getModelMap());
	}
}
