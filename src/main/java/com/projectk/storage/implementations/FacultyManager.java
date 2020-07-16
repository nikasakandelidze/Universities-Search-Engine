package com.projectk.storage.implementations;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import com.projectk.entities.Faculty;
import com.projectk.entities.searchEntities.SearchFaculty;
import com.projectk.storage.connectionFactory.DatabaseConnection;
import com.projectk.storage.connectionFactory.MysqlDatabaseConnection;
import com.projectk.storage.interfaces.helpers.BaseStorage;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class FacultyManager implements BaseStorage<Faculty, SearchFaculty> {

	private DatabaseConnection databaseConnection;

	public FacultyManager(DatabaseConnection databaseConnection) {
		this.databaseConnection = databaseConnection;
	}

	@Override
	public List<Faculty> filter(SearchFaculty searchEntity) throws SQLException {
		Connection connection = databaseConnection.getConnection();
		String sqlCommand = getSqlCommand(searchEntity);
		Statement statement = connection.prepareStatement(sqlCommand);

		return null;
	}

	private String getSqlCommand(SearchFaculty searchFaculty) {
		StringBuilder builder = new StringBuilder("SELECT * FROM faculty f WHERE 1 = 1");

		if (searchFaculty.getFacultyCategory() != null) {
			builder.append(" and f.category = ?");
		}

		if (searchFaculty.getUniversityID() != null) {
			builder.append(" and f.category = ?");
		}

		if (searchFaculty.getMinPrice() != null) {
			builder.append(" and f.price >= ?");
		}

		if (searchFaculty.getMaxPrice() != null) {
			builder.append(" and f.price <= ?");
		}

		return builder.toString();
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
