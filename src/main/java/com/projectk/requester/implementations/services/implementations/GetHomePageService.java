package com.projectk.requester.implementations.services.implementations;

import com.projectk.requester.implementations.services.ServiceResult;
import com.projectk.requester.implementations.services.interfaces.HomePageService;
import org.springframework.stereotype.Component;

import javax.naming.directory.SearchResult;
import java.util.HashMap;

@Component
public class GetHomePageService implements HomePageService {
    @Override
    public ServiceResult getHomePage() {
        return new ServiceResult("HomePage",new HashMap<>());
    }
}
