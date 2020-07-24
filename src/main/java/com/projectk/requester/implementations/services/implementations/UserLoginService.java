package com.projectk.requester.implementations.services.implementations;

import com.projectk.entities.User;
import com.projectk.requester.implementations.services.ServiceResult;
import com.projectk.requester.implementations.services.interfaces.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class UserLoginService implements UserService {
    @Override
    public ServiceResult isUserAuthenticated(User user) {
        String view = "login";
        Map<String,Object> modelMap = new HashMap<>();
        if(user.getUsername().equals("nika") && user.getEncoded_password().equals("123")){
            view = "UserLoginPage";
        }else{
            modelMap.put("errorMessage","Username or password incorrect.");
        }
        return new ServiceResult( view, modelMap);
    }

    @Override
    public ServiceResult updateUser(User user) {
        return null;
    }

    @Override
    public ServiceResult deleteUser(User user) {
        return null;
    }

    @Override
    public ServiceResult addUser(User user) {
        return null;
    }
}
