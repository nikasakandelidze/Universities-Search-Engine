package com.projectk.requester.implementations;

import com.projectk.entities.User;
import com.projectk.requester.implementations.services.ServiceResult;
import com.projectk.requester.implementations.services.interfaces.UserService;
import com.projectk.requester.interfaces.UserRequester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserLogin implements UserRequester {
    private UserService userService;
    @Autowired
    public UserLogin(UserService userService){
        this.userService = userService;
    }

    @Override
    @GetMapping("/login")
    public String displayLogin() {
        return "login";
    }

    @Override
    @PostMapping("/login")
    public ModelAndView executeLogin(@RequestParam String username,
                                     @RequestParam String password,
                                     HttpSession session) {
        ServiceResult serviceResult = userService.isUserAuthenticated(new User(username, password), session);
        return new ModelAndView(serviceResult.getViewName(), serviceResult.getModelMap());
    }
}
