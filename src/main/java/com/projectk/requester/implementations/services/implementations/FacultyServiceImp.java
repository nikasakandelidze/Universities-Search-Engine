package com.projectk.requester.implementations.services.implementations;

import com.projectk.entities.Faculty;
import com.projectk.entities.ServiceResult;
import com.projectk.requester.implementations.services.interfaces.FacultyService;
import com.projectk.storage.connectionManager.customExceptions.StorageException;
import com.projectk.storage.storageManager.implementations.facultystorage.FacultyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class FacultyServiceImp implements FacultyService {
    private FacultyManager facultyManager;

    @Autowired
    public FacultyServiceImp(FacultyManager facultyManager) {
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
}
