package com.projectk.requester.implementations.services.implementations;

import com.projectk.requester.implementations.services.ServiceResult;
import com.projectk.requester.implementations.services.interfaces.HomePageService;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class HomePageServiceImpl implements HomePageService {
    @Override
    public ServiceResult getHomePage() {
        return new ServiceResult("HomePage", new HashMap<>());
    }

    @Override
    public ServiceResult search(String searchData) {
        //todo: change ServiceResult() from hardcoded to actual universal search
        return new ServiceResult("HomePage", new HashMap<>());
    }
}
