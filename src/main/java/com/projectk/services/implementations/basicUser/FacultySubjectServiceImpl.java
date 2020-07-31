package com.projectk.services.implementations.basicUser;

import com.projectk.entities.ServiceResult;
import com.projectk.entities.interfaces.FacultySubjectService;
import com.projectk.entities.interfaces.loggedInUserServices.SubjectService;
import com.projectk.entities.searchEntities.SearchSubject;
import com.projectk.services.interfaces.FacultyService;
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
