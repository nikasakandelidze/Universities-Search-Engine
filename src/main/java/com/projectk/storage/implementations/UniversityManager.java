package com.projectk.storage.implementations;

import com.projectk.entities.Faculty;
import com.projectk.entities.University;
import com.projectk.entities.searchEntities.SearchFaculty;
import com.projectk.entities.searchEntities.SearchUniversity;
import com.projectk.storage.connectionFactory.DatabaseConnection;
import com.projectk.storage.interfaces.helpers.BaseStorage;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UniversityManager implements BaseStorage<University, SearchUniversity> {
    private DatabaseConnection databaseConnection;

    public UniversityManager(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public List<University> filter(SearchUniversity searchEntity) throws SQLException {
        Connection connection = databaseConnection.getConnection();
        String sqlCommand = getSqlCommand(searchEntity);
        Statement statement = connection.prepareStatement(sqlCommand);

        return null;
    }

    private String getSqlCommand(SearchUniversity searchUniversity) {
        StringBuilder builder = new StringBuilder("SELECT * FROM university U WHERE 1 = 1");
        if (searchUniversity.getUniversityId() != null) {
            builder.append("and U.id = ?");
        }
		if (searchUniversity.getCity() != null) {
			builder.append("and U.city = ?");
		}
		if (searchUniversity.getUniversityName() != null) {
			builder.append("and U.university_name = ?");
		}
		if (searchUniversity.getFaculty() != null) {
			builder.append("and U.faculty = ?");
		}
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
