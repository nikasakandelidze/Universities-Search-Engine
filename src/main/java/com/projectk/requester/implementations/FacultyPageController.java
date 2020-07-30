package com.projectk.requester.implementations;

import com.projectk.entities.searchEntities.SearchFaculty;
import com.projectk.requester.implementations.services.ServiceResult;
import com.projectk.requester.implementations.services.interfaces.FacultyService;
import com.projectk.requester.interfaces.FacultyPageRequester;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FacultyPageController implements FacultyPageRequester {
    private FacultyService facultyService;

    @Autowired
    public FacultyPageController(FacultyService facultyService){
        this.facultyService = facultyService;
    }

    @Override
    @GetMapping("/faculty/{facultyId}")
    public Object displayFaculty(@PathVariable int facultyId) {
        ServiceResult facultyById = facultyService.findFacultyById(facultyId);
        return new ModelAndView(facultyById.getViewName(), facultyById.getModelMap());
    }
}
