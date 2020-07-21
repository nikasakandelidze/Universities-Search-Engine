package com.projectk.requester.implementations;

import com.projectk.requester.interfaces.UserRequester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserLogin implements UserRequester {

    @Override
    @GetMapping("/login")
    public String displayLogin() {
        return "login";
    }

    @Override
    @PostMapping("/login")
    public ModelAndView executeLogin(@RequestParam String username,
                                     @RequestParam String password) {
        ModelAndView modelAndView = new ModelAndView("UserHomePage");
        modelAndView.addObject("username", username);
        modelAndView.addObject("password", password);
        return modelAndView;
    }
}
