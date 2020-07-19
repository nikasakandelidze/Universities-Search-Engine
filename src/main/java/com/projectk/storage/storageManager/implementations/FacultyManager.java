package com.projectk.storage.storageManager.implementations;

import com.projectk.entities.Faculty;
import com.projectk.entities.searchEntities.SearchFaculty;
import com.projectk.storage.connectionManager.ConnectionManager;
import com.projectk.storage.connectionManager.customExceptions.StorageException;
import com.projectk.storage.storageManager.interfaces.StorageManager;

import java.sql.*;
import java.util.List;

public class FacultyManager implements StorageManager<Faculty, SearchFaculty> {
	private final ConnectionManager connectionManager;

	public FacultyManager(ConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
	}


	@Override
	public List<Faculty> filter(SearchFaculty searchEntity) throws StorageException {
		Connection connection = null;
		try {
			connection = connectionManager.getConnection();

		} catch (SQLException throwables) {
			throw new StorageException(throwables);
		}

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
