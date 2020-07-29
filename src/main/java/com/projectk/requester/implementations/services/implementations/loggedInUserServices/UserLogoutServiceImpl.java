package com.projectk.requester.implementations.services.implementations.loggedInUserServices;

import com.projectk.requester.implementations.services.ServiceResult;
import com.projectk.requester.implementations.services.interfaces.loggedInUserServices.UserLogoutService;
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
