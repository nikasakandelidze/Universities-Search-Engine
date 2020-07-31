package com.projectk.services.interfaces;

import com.projectk.entities.ServiceResult;

public interface HomePageService {
    ServiceResult getHomePage();

    ServiceResult search(String searchData);

    ServiceResult getFacultyInfo(String faculty);
}
