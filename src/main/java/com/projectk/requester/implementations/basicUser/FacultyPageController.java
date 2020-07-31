package com.projectk.requester.implementations.basicUser;

import com.projectk.entities.ServiceResult;

import com.projectk.entities.interfaces.FacultySubjectService;
import com.projectk.requester.interfaces.basicUser.FacultyPageRequester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FacultyPageController implements FacultyPageRequester {
    private FacultySubjectService facultySubjectService;

    @Autowired
    public FacultyPageController(FacultySubjectService facultySubjectService) {
        this.facultySubjectService = facultySubjectService;
    }

    @Override
    @GetMapping("/faculty/{facultyId}")
    public Object displayFaculty(@PathVariable int facultyId) {
        ServiceResult facultyById = facultySubjectService.getFaculty(facultyId);
        return new ModelAndView(facultyById.getViewName(), facultyById.getModelMap());
    }
}
