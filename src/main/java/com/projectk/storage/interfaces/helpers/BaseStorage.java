package com.projectk.storage.interfaces.helpers;

import com.projectk.entities.Faculty;
import com.projectk.entities.searchEntities.SearchFaculty;

import java.sql.SQLException;
import java.util.List;

public interface BaseStorage<T, Q> {
	List<T> filter(Q searchEntity) throws SQLException;

	void add(T entity);

	void delete(T entity);

	void update(T entity);
}
