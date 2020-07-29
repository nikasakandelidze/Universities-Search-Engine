package com.projectk.requester.implementations.services.implementations;

import com.projectk.entities.Subject;
import com.projectk.requester.implementations.services.ServiceResult;
import com.projectk.requester.implementations.services.interfaces.SubjectService;
import com.projectk.storage.connectionManager.customExceptions.StorageException;
import com.projectk.storage.storageManager.implementations.facultystorage.FacultyManager;
import com.projectk.storage.storageManager.implementations.subjectManager.SubjectManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SubjectServiceImp implements SubjectService {
    private SubjectManager subjectManager;

    @Autowired
    public SubjectServiceImp(SubjectManager subjectManager) {
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
