package com.projectk.requester.implementations.basicUser;

import com.projectk.entities.User;
import com.projectk.entities.ServiceResult;
import com.projectk.services.interfaces.UserService;
import com.projectk.requester.interfaces.basicUser.UserRequester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class UserLoginController implements UserRequester {
    private UserService userService;

    @Autowired
    public UserLoginController(UserService userService) {
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
        serviceResult.getSessionUserAttributes().forEach(session::setAttribute);
        return new ModelAndView(serviceResult.getViewName(), serviceResult.getModelMap());
    }
}
