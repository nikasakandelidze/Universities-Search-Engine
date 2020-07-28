package com.projectk.requester.implementations;

import com.projectk.entities.Faculty;
import com.projectk.entities.University;
import com.projectk.entities.enums.FacultyCategory;
import com.projectk.requester.implementations.services.ServiceResult;
import com.projectk.requester.implementations.services.interfaces.FacultyService;
import com.projectk.requester.interfaces.FacultyRequester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FacultyRegistration implements FacultyRequester {
    private FacultyService facultyService;
    @Autowired
    public FacultyRegistration(FacultyService facultyService){this.facultyService=facultyService;}
    @Override
    @GetMapping("/addfaculty")
    public Object displayFacultyRegistration() {
        return "facultyAdd";
    }

    @Override
    @PostMapping("/addfaculty")
    public Object executeFacultyRegistration(@RequestParam int facultyId,
                                             @RequestParam FacultyCategory category,
                                             @RequestParam int universityId,
                                             @RequestParam String name,
                                             @RequestParam String deanInfo,
                                             @RequestParam long price,
                                             @RequestParam String description,
                                             @RequestParam String webPageLink) {
        ServiceResult serviceResult = facultyService.addFaculty(new Faculty.Builder()
                .facultyId(facultyId)
                .category(category)
                .universityId(universityId)
                .name(name)
                .deanInfo(deanInfo)
                .price(price)
                .description(description)
                .webpage(webPageLink)
                .build());
        return  new ModelAndView(serviceResult.getViewName(), serviceResult.getModelMap());
    }
}
