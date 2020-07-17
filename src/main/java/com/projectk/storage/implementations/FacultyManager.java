package com.projectk.storage.implementations;

import com.projectk.entities.Faculty;
import com.projectk.entities.searchEntities.SearchFaculty;
import com.projectk.storage.dataBaseConnection.DatabaseConnection;
import com.projectk.storage.dataBaseConnection.MysqlDatabaseConnection;
import com.projectk.storage.interfaces.helpers.BaseStorage;

import java.sql.*;
import java.util.List;

public class FacultyManager implements BaseStorage<Faculty, SearchFaculty> {
	public static void main(String[] args) {
		FacultyManager facultyManager = new FacultyManager(new MysqlDatabaseConnection());
		try {
			facultyManager.filter(new SearchFaculty.Builder().build());
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	private DatabaseConnection databaseConnection;

	public FacultyManager(DatabaseConnection databaseConnection) {
		this.databaseConnection = databaseConnection;
	}

	@Override
	public List<Faculty> filter(SearchFaculty searchEntity) throws SQLException {
		Connection connection = databaseConnection.getConnection();
		PreparedStatement preparedStatement =  createPreparedStatement(searchEntity,connection);
		ResultSet resultSet = preparedStatement.executeQuery();

		return null;
	}

	private PreparedStatement createPreparedStatement(SearchFaculty searchFaculty, Connection connection) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(getSqlCommand(searchFaculty));
		fillPreparedStatementWithSearchVariables(statement,searchFaculty);
		return statement;
	}

	private void fillPreparedStatementWithSearchVariables(PreparedStatement statement,SearchFaculty searchFaculty) throws SQLException {
		int variableIndex = 1;
		if(searchFaculty.getUniversityID() != null ){
			statement.setInt(variableIndex,searchFaculty.getUniversityID());
			variableIndex++;
		}
		if (searchFaculty.getFacultyCategory() != null) {
			statement.setString(variableIndex,searchFaculty.getFacultyCategory().name());
			variableIndex++;
		}
		if (searchFaculty.getMinPrice() != null) {
			statement.setLong(variableIndex,searchFaculty.getMaxPrice());
			variableIndex++;
		}
		if (searchFaculty.getMaxPrice() != null) {
			statement.setLong(variableIndex,searchFaculty.getMaxPrice());
			variableIndex++;
		}
	}

	private String getSqlCommand(SearchFaculty searchFaculty) {
		StringBuilder builder = new StringBuilder("SELECT * FROM faculty  f ");
		if(searchFaculty.getUniversityID() != null ){
			builder.append("join university on f.university_id = ? ");
		}
		builder.append(" where 1 = 1 ");
		if (searchFaculty.getFacultyCategory() != null) {
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
