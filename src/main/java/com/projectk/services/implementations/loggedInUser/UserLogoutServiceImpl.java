package com.projectk.services.implementations.loggedInUser;

import com.projectk.entities.ServiceResult;
import com.projectk.services.interfaces.loggedInUserServices.UserLogoutService;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserLogoutServiceImpl implements UserLogoutService {
    @Override
    public ServiceResult logout() {
        String viewName = "login";
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("logoutMessage","Logged out successfully");
        return new ServiceResult(viewName,modelMap);
    }
}
