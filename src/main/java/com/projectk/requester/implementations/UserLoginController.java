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

import javax.servlet.http.HttpSession;
import java.util.List;

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
        List<Object> sessionUserAttributes = serviceResult.getSessionUserAttribute();
        if (sessionUserAttributes.size()>0 && sessionUserAttributes.get(0) != null)
            session.setAttribute("user", sessionUserAttributes.get(0));
        if (sessionUserAttributes.size()>1 && sessionUserAttributes.get(1) != null)
            session.setAttribute("allUniversities",sessionUserAttributes.get(1));
        return new ModelAndView(serviceResult.getViewName(), serviceResult.getModelMap());
    }
}
