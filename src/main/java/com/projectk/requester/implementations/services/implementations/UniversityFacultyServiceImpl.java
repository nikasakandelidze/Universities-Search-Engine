package com.projectk.requester.implementations.services.implementations;

import com.projectk.entities.Faculty;
import com.projectk.entities.University;
import com.projectk.entities.searchEntities.SearchFaculty;
import com.projectk.entities.searchEntities.SearchUniversity;
import com.projectk.requester.implementations.services.ServiceResult;
import com.projectk.requester.implementations.services.interfaces.FacultyService;
import com.projectk.requester.implementations.services.interfaces.UniversityFacultyService;
import com.projectk.requester.implementations.services.interfaces.loggedInUserServices.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class UniversityFacultyServiceImpl implements UniversityFacultyService {
    private UniversityService universityService;
    private FacultyService facultyService;

    @Autowired
    public UniversityFacultyServiceImpl(UniversityService universityService, FacultyService facultyService) {
        this.universityService = universityService;
        this.facultyService = facultyService;
    }

    @Override
    public ServiceResult getUniversity(int universityId) {
        ServiceResult universityServiceResult = universityService.filterUniversities(new SearchUniversity.Builder()
                .universityId(universityId)
                .build());
        ServiceResult facultyServiceResult = facultyService.filterFaculties(new SearchFaculty.Builder()
                .universityId(universityId)
                .build());
        universityServiceResult.getModelMap().putAll(facultyServiceResult.getModelMap());
        return universityServiceResult;
    }
}
