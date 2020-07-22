package com.projectk.requester.implementations;

import com.projectk.entities.User;
import com.projectk.requester.implementations.services.ServiceResult;
import com.projectk.requester.implementations.services.interfaces.UserService;
import com.projectk.requester.interfaces.UserRequester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
                                     @RequestParam String password) {
        ServiceResult serviceResult = userService.isUserAuthenticated(new User(username, password));
        return new ModelAndView(serviceResult.getViewName(),serviceResult.getModelMap());
    }
}
