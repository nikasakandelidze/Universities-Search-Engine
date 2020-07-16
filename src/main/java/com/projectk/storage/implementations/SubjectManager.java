package com.projectk.storage.implementations;

import com.projectk.entities.Subject;
import com.projectk.entities.searchEntities.SearchSubject;
import com.projectk.storage.interfaces.helpers.BaseStorage;

import java.util.List;

public class SubjectManager implements BaseStorage <Subject, SearchSubject> {
	@Override
	public List<Subject> filter(SearchSubject searchEntity) {
		return null;
	}

	@Override
	public void add(Subject entity) {

	}

	@Override
	public void delete(Subject entity) {

	}

	@Override
	public void update(Subject entity) {

	}
}
