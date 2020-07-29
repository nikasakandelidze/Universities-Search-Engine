package com.projectk.requester.implementations;

import com.projectk.requester.implementations.services.ServiceResult;
import com.projectk.requester.implementations.services.interfaces.HomePageService;
import com.projectk.requester.interfaces.HomePageRequester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomePage implements HomePageRequester {
    private HomePageService homePageService;

    @Autowired
    public HomePage(HomePageService homePageService) {
        this.homePageService = homePageService;
    }

    @Override
    @GetMapping("/homepage")
    public Object displayHomePage() {
        ServiceResult homePage = homePageService.getHomePage();
        return new ModelAndView(homePage.getViewName(), homePage.getModelMap());
    }

    @Override
    @PostMapping("/homepage/search")
    public Object search(@RequestBody String searchData) {
        ServiceResult searchResult = homePageService.search(searchData);
        return new ModelAndView(searchResult.getViewName(), searchResult.getModelMap());
    }

    @Override
    @GetMapping("/homepage/faculties/{facultyCategory}")
    public Object displayFaculty(@PathVariable String facultyCategory) {
        ServiceResult facultyInfo = homePageService.getFacultyInfo(facultyCategory);
        return new ModelAndView(facultyInfo.getViewName(), facultyInfo.getModelMap());
    }
}
