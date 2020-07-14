package com.projectk.storage.implementations;

import com.projectk.entities.Faculty;
import com.projectk.entities.Subject;
import com.projectk.entities.University;
import com.projectk.entities.searchEntities.SearchFaculty;
import com.projectk.entities.searchEntities.SearchSubject;
import com.projectk.entities.searchEntities.SearchUniversity;
import com.projectk.storage.connectionFactory.DatabaseConnection;
import com.projectk.storage.interfaces.Storage;

import java.util.List;

public class StorageManager implements Storage {
	private DatabaseConnection connection;

	@Override
	public List<Faculty> filterFaculties(SearchFaculty searchFaculty) {
		return null;
	}

	@Override
	public void addFaculty(Faculty faculty) {

	}

	@Override
	public void deleteFaculty(Faculty faculty) {

	}

	@Override
	public void updateFaculty(Faculty faculty) {

	}

	@Override
	public List<Subject> filterSubject(SearchSubject searchSubject) {
		return null;
	}

	@Override
	public void addSubject(Subject subject) {

	}

	@Override
	public void deleteSubject(Subject subject) {

	}

	@Override
	public void updateSubject(Subject subject) {

	}

	@Override
	public List<University> filterUniversity(SearchUniversity searchUniversity) {
		return null;
	}

	@Override
	public void addUniversity(University university) {

	}

	@Override
	public void deleteUniversity(University university) {

	}

	@Override
	public void updateUniversity(University university) {

	}
}
