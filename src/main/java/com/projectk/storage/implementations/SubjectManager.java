package com.projectk.storage.implementations;

import com.projectk.entities.Subject;
import com.projectk.entities.searchEntities.SearchSubject;
import com.projectk.storage.dataBaseConnection.DatabaseConnection;
import com.projectk.storage.interfaces.helpers.BaseStorage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class SubjectManager implements BaseStorage<Subject, SearchSubject> {

    private DatabaseConnection databaseConnection;

    public SubjectManager(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public List<Subject> filter(SearchSubject searchEntity) throws SQLException {
        Connection connection = databaseConnection.getConnection();
        String sqlCommand = getSqlCommand(searchEntity);
        Statement statement = connection.prepareStatement(sqlCommand);
        return null;
    }

    public static void main(String[] args) {
        
    }
    private void fillPreparedStatement(PreparedStatement statement,SearchSubject searchSubject) throws  SQLException{
        int variableIndex=1;
        if(searchSubject.getFacultyId()!=null){
            statement.setInt(variableIndex,searchSubject.getFacultyId());
            variableIndex++;
        }
        if(searchSubject.getSubjectName()!=null){
            statement.setString(variableIndex,searchSubject.getSubjectName());
            variableIndex++;
        }
        if(searchSubject.getFacultyId()!=null && searchSubject.getUniversityId()!=null){
            statement.setInt(variableIndex,searchSubject.getFacultyId());
            variableIndex++;
            statement.setInt(variableIndex,searchSubject.getUniversityId());
        }
    }

    private String getSqlCommand(SearchSubject searchSubject) {
        StringBuilder builder = new StringBuilder("SELECT * FROM university_subject us");
        builder.append("join faculty f on  us.faculty_id=f.faculty_id\n" +
                "join university u on f.university_id = u.id\n" +
                "where 1=1");
        if (searchSubject.getFacultyId() != null) {
            builder.append("and f.faculty_id=?");
        }
        if (searchSubject.getSubjectName() != null) {
            builder.append("and f.subject_name=?");
        }
        if (searchSubject.getUniversityId() != null && searchSubject.getFacultyId() != null) {
            builder.append("and f.faculty_id =? and u.id=?");
        }
        return builder.toString();
    }

    @Override
    public void add(Subject entity) {

    }

    @Override
    public void delete(Subject entity) {

    }

    @Override
    public void update(Subject entity) {

    }
}
