package com.projectk.storage.implementations;

import com.projectk.entities.University;
import com.projectk.entities.searchEntities.SearchUniversity;
import com.projectk.storage.dataBaseConnection.DatabaseConnection;
import com.projectk.storage.interfaces.helpers.BaseStorage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UniversityManager implements BaseStorage<University, SearchUniversity> {
    private DatabaseConnection databaseConnection;

    public UniversityManager(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public List<University> filter(SearchUniversity searchUniversity) throws SQLException {
        Connection connection = databaseConnection.getConnection();
        String sqlCommand = getSqlCommand(searchUniversity);
        Statement statement = connection.prepareStatement(sqlCommand);

        return null;
    }
    private void fillPreparedStatement(PreparedStatement statement, SearchUniversity searchUniversity) throws  SQLException{
        int variableIndex=1;
        if(searchUniversity.getUniversityId()!=null){
            statement.setInt(variableIndex,searchUniversity.getUniversityId());
            variableIndex++;
        }
        if(searchUniversity.getCity()!=null){
            statement.setString(variableIndex,searchUniversity.getCity());
            variableIndex++;
        }
        if(searchUniversity.getUniversityName()!=null){
            statement.setString(variableIndex,searchUniversity.getUniversityName());
            variableIndex++;
        }
//        if(searchUniversity.getFaculty()!=null){
//            statement.setString(variableIndex,searchUniversity.getFaculty());
//            variableIndex++;
//        }
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
		if (searchUniversity.getFacultyCategory() != null) {
			builder.append("and U.facultyCategory = ?");
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
