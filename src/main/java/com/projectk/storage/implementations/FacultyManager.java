package com.projectk.storage.implementations;

import com.projectk.entities.Faculty;
import com.projectk.entities.searchEntities.SearchFaculty;
import com.projectk.storage.interfaces.helpers.BaseStorage;

import java.util.List;

public class FacultyManager	implements BaseStorage <Faculty, SearchFaculty> {
	@Override
	public List<Faculty> filter(SearchFaculty searchEntity) {
		return null;
	}

	@Override
	public void add(Faculty entity) {

	}

	@Override
	public void delete(Faculty entity) {

	}

	@Override
	public void update(Faculty entity) {

	}
}
