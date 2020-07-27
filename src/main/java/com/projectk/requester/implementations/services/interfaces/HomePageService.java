package com.projectk.requester.implementations.services.interfaces;

import com.projectk.requester.implementations.services.ServiceResult;

public interface HomePageService {
    ServiceResult getHomePage();
    ServiceResult search(String searchData);
    ServiceResult getFacultyInfo(String faculty);
}
