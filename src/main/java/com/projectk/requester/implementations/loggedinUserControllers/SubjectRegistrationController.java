package com.projectk.requester.implementations.loggedinUserControllers;

import com.projectk.entities.Subject;
import com.projectk.requester.implementations.services.ServiceResult;
import com.projectk.requester.implementations.services.interfaces.loggedInUserServices.SubjectRegistrationService;
import com.projectk.requester.interfaces.loggedinUserRequesters.SubjectRegisterRequester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class SubjectRegistrationController implements SubjectRegisterRequester {
    private SubjectRegistrationService subjectRegistrationService;

    @Autowired
    public SubjectRegistrationController(SubjectRegistrationService subjectRegistrationService) {
        this.subjectRegistrationService = subjectRegistrationService;
    }


    @Override
    @GetMapping("/addsubject")
    public Object displaySubjectRegistration() {
        return "subjectAdd";
    }

    @Override
    @PostMapping("/addsubject")
    public Object executeSubjectRegistration(@RequestParam int subjectId,
                                             @RequestParam int facultyId,
                                             @RequestParam String subjectName,
                                             @RequestParam int credits,
                                             @RequestParam String descriptions,
                                             @RequestParam int semester) {
        ServiceResult serviceResult = subjectRegistrationService.addSubject(new Subject.Builder()
                .subject_id(subjectId)
                .faculty_id(facultyId)
                .subject_name(subjectName)
                .credits(credits)
                .descriptions(descriptions)
                .semester(semester)
                .build());
        return new ModelAndView(serviceResult.getViewName(), serviceResult.getModelMap());
    }
}
