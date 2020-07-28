package com.projectk.requester.implementations;

import com.projectk.entities.User;
import com.projectk.entities.ServiceResult;
import com.projectk.requester.implementations.services.interfaces.UserService;
import com.projectk.requester.interfaces.UserRequester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class UserLogin implements UserRequester {
    private UserService userService;

    @Autowired
    public UserLogin(UserService userService) {
        this.userService = userService;
    }

    @Override
    @GetMapping("/login")
    public ModelAndView displayLogin(HttpSession httpSession) {
        ServiceResult serviceResult = userService.displayLogin(httpSession.getAttribute("user"));
        return new ModelAndView(serviceResult.getViewName(), serviceResult.getModelMap());
    }

    @Override
    @PostMapping("/login")
    public ModelAndView executeLogin(@RequestParam String username, @RequestParam String password, HttpSession session) {
        ServiceResult serviceResult = userService.isUserAuthenticated(User.newUserWithEncryptedPass(username, password), session.getAttribute("user"));
        Object sessionUserAttribute = serviceResult.getSessionUserAttribute();
        if (sessionUserAttribute != null)
            session.setAttribute("user", sessionUserAttribute);
        return new ModelAndView(serviceResult.getViewName(), serviceResult.getModelMap());
    }
}
