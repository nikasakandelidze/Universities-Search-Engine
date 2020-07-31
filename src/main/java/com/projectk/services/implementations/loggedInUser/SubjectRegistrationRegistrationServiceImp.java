package com.projectk.services.implementations.loggedInUser;

import com.projectk.entities.Subject;
import com.projectk.entities.searchEntities.SearchSubject;
import com.projectk.entities.ServiceResult;
import com.projectk.services.interfaces.loggedInUserServices.SubjectRegistrationService;
import com.projectk.storage.connectionManager.customExceptions.StorageException;
import com.projectk.storage.storageManager.interfaces.StorageManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SubjectRegistrationRegistrationServiceImp implements SubjectRegistrationService {
    private StorageManager<Subject, SearchSubject> subjectManager;

    @Autowired
    public SubjectRegistrationRegistrationServiceImp(StorageManager<Subject, SearchSubject> subjectManager) {
        this.subjectManager = subjectManager;
    }

    @Override
    public ServiceResult addSubject(Subject subject) {
        String view = "subjectAdd";
        Map<String, Object> modelMap = new HashMap<>();
        try {
            subjectManager.add(subject);
            view = "UserPage";
        } catch (StorageException e) {
            modelMap.put("errorMessage", "Subject name already exists!");
        }
        return new ServiceResult(view, modelMap);
    }

    @Override
    public ServiceResult updateSubject(Subject subject) {
        String view = "subjectAdd";
        Map<String, Object> modelMap = new HashMap<>();
        try {
            subjectManager.update(subject);
        } catch (StorageException e) {
            modelMap.put("errorMessage", "Ups something went wrong...");
        }
        return new ServiceResult(view, modelMap);
    }

}
