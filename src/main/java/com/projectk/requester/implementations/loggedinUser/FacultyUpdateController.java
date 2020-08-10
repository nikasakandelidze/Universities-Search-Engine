package com.projectk.requester.implementations.loggedinUser;

import com.projectk.entities.Faculty;
import com.projectk.entities.ServiceResult;
import com.projectk.requester.interfaces.loggedinUserRequesters.FacultyUpdateRequester;
import com.projectk.services.interfaces.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class FacultyUpdateController implements FacultyUpdateRequester {
	private FacultyService facultyService;

	@Autowired
	public FacultyUpdateController(FacultyService facultyService) {
		this.facultyService = facultyService;
	}

	@Override
	@GetMapping("/facultyUpdate/{facultyId}")
	public Object displayFacultyUpdate(@PathVariable String facultyId, HttpSession session) {
		ServiceResult result = facultyService.findFacultyById(facultyId, "facultyUpdate", true);
		return new ModelAndView(result.getViewName(), result.getModelMap());
	}

	@Override
	@PostMapping("/facultyUpdate")
	public Object executeFacultyUpdate(Faculty faculty) {
		ServiceResult result = facultyService.updateFaculty(faculty);
		return new ModelAndView(result.getViewName(), result.getModelMap());
	}
}
