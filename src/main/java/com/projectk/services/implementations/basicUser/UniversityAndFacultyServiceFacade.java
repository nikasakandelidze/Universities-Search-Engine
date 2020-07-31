package com.projectk.services.implementations.basicUser;

import com.projectk.entities.searchEntities.SearchFaculty;
import com.projectk.entities.searchEntities.SearchUniversity;
import com.projectk.entities.ServiceResult;
import com.projectk.services.interfaces.FacultyService;
import com.projectk.services.interfaces.UniversityFacultyService;
import com.projectk.services.interfaces.loggedInUserServices.UniversityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UniversityAndFacultyServiceFacade implements UniversityFacultyService {
    private UniversityService universityService;
    private FacultyService facultyService;

    @Autowired
    public UniversityAndFacultyServiceFacade(UniversityService universityService, FacultyService facultyService) {
        this.universityService = universityService;
        this.facultyService = facultyService;
    }

    @Override
    public ServiceResult getUniversity(int universityId) {
        ServiceResult mainServiceResult = universityService
                .filterUniversities(SearchUniversity.selectUnviersityById(universityId));
        ServiceResult secondaryServiceResult = facultyService
                .filterFaculties(SearchFaculty.selectFacultyWithUniversityId(universityId));
        mainServiceResult.getModelMap().putAll(secondaryServiceResult.getModelMap());
        return mainServiceResult;
    }
}
