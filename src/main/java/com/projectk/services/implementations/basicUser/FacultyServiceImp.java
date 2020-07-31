package com.projectk.services.implementations.basicUser;

import com.projectk.entities.Faculty;
import com.projectk.entities.searchEntities.SearchFaculty;
import com.projectk.entities.ServiceResult;
import com.projectk.services.interfaces.FacultyService;
import com.projectk.storage.connectionManager.customExceptions.StorageException;
import com.projectk.storage.storageManager.interfaces.StorageManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class FacultyServiceImp implements FacultyService {
    private StorageManager<Faculty, SearchFaculty> facultyManager;

    @Autowired
    public FacultyServiceImp(StorageManager<Faculty, SearchFaculty> facultyManager) {
        this.facultyManager = facultyManager;
    }

    @Override
    public ServiceResult addFaculty(Faculty faculty) {
        String view = "facultyAdd";
        Map<String, Object> modelMap = new HashMap<>();
        try {
            facultyManager.add(faculty);
            view = "UserPage";
        } catch (StorageException e) {
            modelMap.put("errorMessage", "Faculty name already exists!");
        }
        return new ServiceResult(view, modelMap);
    }

    @Override
    public ServiceResult updateFaculty(Faculty faculty) {
        String view = "facultyAdd";
        Map<String, Object> modelMap = new HashMap<>();
        try {
            facultyManager.update(faculty);
        } catch (StorageException e) {
            modelMap.put("errorMessage", "Ups something went wrong...");
        }
        return new ServiceResult(view, modelMap);
    }

    @Override
    public ServiceResult filterFaculties(SearchFaculty searchFaculty) {
        String view = "HomePage";
        Map<String, Object> modelMap = new HashMap<>();
        try {
            List<Faculty> resultList = facultyManager.filter(searchFaculty);
            modelMap.put("allFaculties", resultList);
            view = "facultyListing";
        } catch (StorageException e) {
            modelMap.put("errorMessage", "Ups something went wrong...");
        }
        return new ServiceResult(view, modelMap);
    }

    @Override
    public ServiceResult findFacultyById(int id) {
        String view= "faculty";
        Map<String,Object> modelMap = new HashMap<>();
        try {
            modelMap.put("faculty",facultyManager.find(id).get());
        } catch (Exception e) {
            view = "facultyListing";
        }
        return new ServiceResult(view,modelMap);
    }
}
