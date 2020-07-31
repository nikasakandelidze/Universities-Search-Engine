package com.projectk.requester.implementations.services.implementations.loggedInUserServices;

import com.projectk.entities.Subject;
import com.projectk.entities.University;
import com.projectk.entities.searchEntities.SearchSubject;
import com.projectk.requester.implementations.services.ServiceResult;
import com.projectk.requester.implementations.services.interfaces.loggedInUserServices.SubjectService;
import com.projectk.storage.connectionManager.customExceptions.StorageException;
import com.projectk.storage.storageManager.implementations.subjectManager.SubjectManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
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

    @Override
    public ServiceResult filterSubjects(SearchSubject searchSubject) {
        String view = "HomePage";
        Map<String, Object> modelMap = new HashMap<>();
        try {
            List<Subject> resultList = subjectManager.filter(searchSubject);
            if (resultList.isEmpty()) {
                modelMap.put("errorMessage", "No results found!");
            } else {
                modelMap.put("allSubjects", resultList);
                view = "subjectListing";
            }

        } catch (StorageException e) {
            modelMap.put("errorMessage", "Ups something went wrong...");
        }
        return new ServiceResult(view, modelMap);
    }

}
