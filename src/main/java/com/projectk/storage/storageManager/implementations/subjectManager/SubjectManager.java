package com.projectk.storage.storageManager.implementations.subjectManager;

import com.projectk.entities.Subject;
import com.projectk.entities.searchEntities.SearchSubject;
import com.projectk.storage.connectionManager.ConnectionManager;
import com.projectk.storage.connectionManager.MysqlConnectionManager;
import com.projectk.storage.connectionManager.customExceptions.StorageException;
import com.projectk.storage.storageManager.implementations.subjectManager.executableStatementGenerator.helpers.PreparedStatementGenerator.implementations.searchSubjectPreparedStatementGenerator;
import com.projectk.storage.storageManager.implementations.subjectManager.executableStatementGenerator.helpers.PreparedStatementGenerator.interfaces.PreparedStatementGenerator;
import com.projectk.storage.storageManager.implementations.subjectManager.executableStatementGenerator.helpers.sqlQueryGenerators.implementations.SearchSubjectWildCardSqlQueryGenerator;
import com.projectk.storage.storageManager.implementations.subjectManager.executableStatementGenerator.helpers.sqlQueryGenerators.interfaces.WildCardSqlQueryGenerator;
import com.projectk.storage.storageManager.interfaces.StorageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SubjectManager implements StorageManager<Subject, SearchSubject> {
    private ConnectionManager connectionManager;

    @Autowired
    public SubjectManager(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public List<Subject> filter(SearchSubject searchEntity) throws StorageException {
        Connection connection = null;
        List<Subject> resultList = new ArrayList<>();
        try {
            connection = connectionManager.getConnection();
            PreparedStatementGenerator statementGenerator = new searchSubjectPreparedStatementGenerator(connection);
            WildCardSqlQueryGenerator sqlQueryGenerator = new SearchSubjectWildCardSqlQueryGenerator();
            String query = sqlQueryGenerator.generateWildCardQueryFromSearchEntity(searchEntity);
            PreparedStatement statement = (PreparedStatement) statementGenerator.generatePreparedStatementFromSqlQuery(query, searchEntity);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                resultList.add(SubjectUtils.getSubject(set));
            }
        } catch (SQLException throwables) {
            throw new StorageException(throwables);
        }
        return resultList;
    }

    private void insertValues(Subject entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, entity.getSubjectId());
        preparedStatement.setInt(2, entity.getFacultyId());
        preparedStatement.setString(3, entity.getSubjectName());
        preparedStatement.setInt(4, entity.getCredits());
        preparedStatement.setString(5, entity.getDescriptions());
        preparedStatement.setInt(6, entity.getSemester());
    }

    @Override
    public void add(Subject entity) throws  StorageException{
        Connection connection = null;
        try {
            connection = connectionManager.getConnection();
            String query = "INSERT INTO university_subject VALUES(?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            insertValues(entity, preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throw new StorageException(throwables);
        }

    }

    @Override
    public void delete(Subject entity) throws StorageException{
        Connection connection = null;
        try {
            connection = connectionManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM university_subject WHERE subject_id=?");
            preparedStatement.setInt(1, entity.getSubjectId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throw  new StorageException(throwables);
        }
    }

    @Override
    public void update(Subject entity) throws StorageException {
        Connection connection = null;
        try {
            connection = connectionManager.getConnection();

            String query = "UPDATE university_subject SET  subject_name=? " + ", credits=? , descriptions=? , semester=? WHERE subject_id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            updateValues(entity, preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throw  new StorageException(throwables);
        }
    }

    private void updateValues(Subject entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, entity.getSubjectName());
        preparedStatement.setInt(2, entity.getCredits());
        preparedStatement.setString(3, entity.getDescriptions());
        preparedStatement.setInt(4, entity.getSemester());
        preparedStatement.setInt(5, entity.getSubjectId());
    }
}
