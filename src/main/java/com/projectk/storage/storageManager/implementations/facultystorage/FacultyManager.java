package com.projectk.storage.storageManager.implementations.facultystorage;

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

	public static void main(String[] args) throws StorageException {
		FacultyManager m = new FacultyManager(new MysqlConnectionManager());
		SearchFaculty f = new SearchFaculty.Builder()
				//.category(FacultyCategory.CS)
//				.maxPrice(1000L)
//				.minPrice(100L)
				.build();
		m.filter(f);
	}

	@Override
	public List<Faculty> filter(SearchFaculty searchEntity) throws StorageException {
		try {
			PreparedStatement statement = new FacultySelectStatementBuilder(connectionManager.getConnection())
					.byCategory(searchEntity.getFacultyCategory())
					.byMinPrice(searchEntity.getMinPrice())
					.byMaxPrice(searchEntity.getMaxPrice())
					.byUniversityId(searchEntity.getUniversityID())
					.build();
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				System.out.println(name);
			}
			int a = 222;
		} catch (Exception e) {
			throw new StorageException(e);
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
