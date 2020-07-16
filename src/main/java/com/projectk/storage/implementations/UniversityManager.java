package com.projectk.storage.implementations;

import com.projectk.entities.University;
import com.projectk.entities.searchEntities.SearchUniversity;
import com.projectk.storage.interfaces.helpers.BaseStorage;

import java.util.List;

public class UniversityManager implements BaseStorage <University, SearchUniversity> {
	@Override
	public List<University> filter(SearchUniversity searchEntity) {
		return null;
	}

	@Override
	public void add(University entity) {

	}

	@Override
	public void delete(University entity) {

	}

	@Override
	public void update(University entity) {

	}
}
