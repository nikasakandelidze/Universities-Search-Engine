package com.projectk.requester.implementations.basicUser;

import com.projectk.entities.ServiceResult;
import com.projectk.services.interfaces.HomePageService;
import com.projectk.requester.interfaces.basicUser.HomePageRequester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomePageController implements HomePageRequester {
    private HomePageService homePageService;

    @Autowired
    public HomePageController(HomePageService homePageService) {
        this.homePageService = homePageService;
    }

    @Override
    @GetMapping("/homepage")
    public Object displayHomePage() {
        ServiceResult homePage = homePageService.getHomePage();
        return new ModelAndView(homePage.getViewName(), homePage.getModelMap());
    }

    @Override
    @PostMapping("/homepage/search/{universityName}")
    public Object search(@PathVariable String universityName) {
        return "redirect:/universityListing/"+universityName;
    }

    @Override
    @GetMapping("/homepage/faculties/{facultyCategory}")
    public Object displayFaculty(@PathVariable String facultyCategory) {
        ServiceResult facultyInfo = homePageService.getFacultyInfo(facultyCategory);
        return new ModelAndView(facultyInfo.getViewName(), facultyInfo.getModelMap());
    }
}
