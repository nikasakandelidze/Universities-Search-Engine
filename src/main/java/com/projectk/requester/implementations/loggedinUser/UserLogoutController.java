package com.projectk.requester.implementations.loggedinUser;

import com.projectk.entities.ServiceResult;
import com.projectk.services.interfaces.loggedInUserServices.UserLogoutService;
import com.projectk.requester.interfaces.loggedinUserRequesters.UserLogoutRequester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class UserLogoutController implements UserLogoutRequester {
    private UserLogoutService logoutService;

    @Autowired
    public UserLogoutController(UserLogoutService logoutService) {
        this.logoutService = logoutService;
    }

    @Override
    @GetMapping("/user/logout")
    public Object executeLogout(HttpSession session) {
        session.invalidate();
        ServiceResult logout = logoutService.logout();
        return new ModelAndView(logout.getViewName(), logout.getModelMap());
    }
}
