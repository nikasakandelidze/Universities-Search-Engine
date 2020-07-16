package com.projectk.storage.interfaces.helpers;

import com.projectk.entities.Faculty;
import com.projectk.entities.searchEntities.SearchFaculty;

import java.util.List;

public interface BaseStorage<T, Q> {
	List<T> filter(Q searchEntity);

	void add(T entity);

	void delete(T entity);

	void update(T entity);
}
