package com.projectk.requester.implementations.services.implementations;

import com.projectk.entities.searchEntities.SearchFaculty;
import com.projectk.entities.searchEntities.SearchSubject;
import com.projectk.entities.searchEntities.SearchUniversity;
import com.projectk.requester.implementations.services.ServiceResult;
import com.projectk.requester.implementations.services.interfaces.FacultyService;
import com.projectk.requester.implementations.services.interfaces.FacultySubjectService;
import com.projectk.requester.implementations.services.interfaces.loggedInUserServices.SubjectService;
import com.projectk.requester.implementations.services.interfaces.loggedInUserServices.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultySubjectServiceImpl implements FacultySubjectService {
	private SubjectService subjectService;
	private FacultyService facultyService;

	@Autowired
	public FacultySubjectServiceImpl(SubjectService subjectService, FacultyService facultyService) {
		this.subjectService = subjectService;
		this.facultyService = facultyService;
	}

	@Override
	public ServiceResult getFaculty(int facultyId) {
		ServiceResult subjectServiceResult = subjectService.filterSubjects(new SearchSubject.Builder()
				.facultyId(facultyId)
				.build());
		ServiceResult facultyServiceResult = facultyService.findFacultyById(facultyId);
		facultyServiceResult.getModelMap().putAll(subjectServiceResult.getModelMap());
		return facultyServiceResult;
	}
}
