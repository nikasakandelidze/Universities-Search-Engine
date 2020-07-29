package com.projectk.requester.implementations.services.implementations;

import com.projectk.entities.Faculty;
import com.projectk.entities.searchEntities.SearchFaculty;
import com.projectk.requester.implementations.services.ServiceResult;
import com.projectk.requester.implementations.services.interfaces.HomePageService;
import com.projectk.storage.connectionManager.customExceptions.StorageException;
import com.projectk.storage.storageManager.implementations.facultystorage.FacultyUtils;
import com.projectk.storage.storageManager.interfaces.StorageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HomePageServiceImpl implements HomePageService {
    private StorageManager<Faculty, SearchFaculty> facultyStorageManager;

    @Autowired
    public HomePageServiceImpl(StorageManager<Faculty, SearchFaculty> facultyStorageManager) {
        this.facultyStorageManager = facultyStorageManager;
    }

    @Override
    public ServiceResult getHomePage() {
        List<Faculty> filter = new ArrayList<>();
        try {
            filter = facultyStorageManager.filter(SearchFaculty.selectAll());
        } catch (StorageException e) {
            e.printStackTrace();
        }
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("faculties", filter);
        return new ServiceResult("HomePage", modelMap);
    }

    @Override
    public ServiceResult search(String searchData) {
        //todo: change ServiceResult() from hardcoded to actual universal search
        return new ServiceResult("HomePage", new HashMap<>());
    }

    @Override
    public ServiceResult getFacultyInfo(String facultyCategory) {
        List<Faculty> filter = new ArrayList<>();
        try {
            filter = facultyStorageManager.filter(new SearchFaculty.Builder().category(FacultyUtils.getCategory(facultyCategory)).build());
        } catch (StorageException e) {
            e.printStackTrace();
        }
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("faculty", filter);
        return new ServiceResult("Faculty", modelMap);
    }
}
