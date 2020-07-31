package com.projectk.requester.implementations.basicUser;

import com.projectk.entities.User;
import com.projectk.entities.ServiceResult;
import com.projectk.services.interfaces.UserService;
import com.projectk.services.implementations.utils.EncryptionUtils;
import com.projectk.requester.interfaces.basicUser.UserRegistrationRequester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserRegistrationController implements UserRegistrationRequester {
    private UserService userService;

    @Autowired
    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @Override
    @GetMapping("/register")
    public Object displayRegistration() {
        return "register";
    }

    @Override
    @PostMapping("/register")
    public ModelAndView executeRegistration(@RequestParam String username,
                                            @RequestParam String password) {
        ServiceResult serviceResult = userService.addUser(new User(username, EncryptionUtils.encodeSHA1(password)));
        return new ModelAndView(serviceResult.getViewName(), serviceResult.getModelMap());
    }
}
