package com.projectk.requester.implementations.loggedinUser;

import com.projectk.entities.Faculty;
import com.projectk.entities.enums.FacultyCategory;
import com.projectk.entities.ServiceResult;
import com.projectk.services.interfaces.FacultyService;
import com.projectk.requester.interfaces.loggedinUserRequesters.FacultyRegisterRequester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class FacultyRegistrationController implements FacultyRegisterRequester {
    private FacultyService facultyService;

    @Autowired
    public FacultyRegistrationController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @Override
    @GetMapping("/addfaculty/{universityId}")
    public Object displayFacultyRegistration(@PathVariable int universityId) {
        Map<String,Object> modelMap = new HashMap<>(){{
            put("universityId",universityId);
        }};
        return new ModelAndView("facultyAdd",modelMap);
    }

    @Override
    @PostMapping("/addfaculty/{universityId}")
    public Object executeFacultyRegistration(@RequestParam int code,
                                             @RequestParam String category,
                                             @RequestParam String name,
                                             @RequestParam String dean,
                                             @RequestParam long price,
                                             @RequestParam String description,
                                             @RequestParam String webPage,
                                             @PathVariable int universityId) {
        ServiceResult serviceResult = facultyService.addFaculty(new Faculty.Builder()
                .facultyId(code)
                .category(FacultyCategory.valueOf(category))
                .universityId(universityId)
                .name(name)
                .deanInfo(dean)
                .price(price)
                .description(description)
                .webpage(webPage)
                .build());
        return new ModelAndView(serviceResult.getViewName(), serviceResult.getModelMap());
    }
}
