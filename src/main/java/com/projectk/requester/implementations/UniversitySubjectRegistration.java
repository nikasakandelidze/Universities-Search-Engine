package com.projectk.requester.implementations;

import com.projectk.entities.Subject;
import com.projectk.requester.implementations.services.ServiceResult;
import com.projectk.requester.implementations.services.interfaces.SubjectService;
import com.projectk.requester.interfaces.SubjectRequester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UniversitySubjectRegistration implements SubjectRequester {
    private SubjectService subjectService;

    @Autowired
    public UniversitySubjectRegistration(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @Override
    @GetMapping("/addsubject")
    public Object displaySubjectRegistration() {
        return "subjectAdd";
    }

    @Override
    @GetMapping("/addsubject")
    public Object executeSubjectRegistration(@RequestParam int subjectId,
                                             @RequestParam int facultyId,
                                             @RequestParam String subjectName,
                                             @RequestParam int credits,
                                             @RequestParam String descriptions,
                                             @RequestParam int semester) {
        ServiceResult serviceResult = subjectService.addSubject(new Subject.Builder()
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