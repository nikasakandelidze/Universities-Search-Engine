package com.projectk.storage.storageManager.implementations;

import com.projectk.entities.Subject;
import com.projectk.entities.searchEntities.SearchSubject;
import com.projectk.storage.connectionManager.ConnectionManager;
import com.projectk.storage.connectionManager.MysqlConnectionManager;
import com.projectk.storage.connectionManager.customExceptions.StorageException;
import com.projectk.storage.storageManager.implementations.helpers.executableStatementGenerator.ExecutableStatementGenerator;
import com.projectk.storage.storageManager.implementations.helpers.executableStatementGenerator.helpers.PreparedStatementGenerator.implementations.SearchFacultyPreparedStatementGenerator;
import com.projectk.storage.storageManager.implementations.helpers.executableStatementGenerator.helpers.PreparedStatementGenerator.implementations.SearchSubjectPreparedStatementGenerator;
import com.projectk.storage.storageManager.implementations.helpers.executableStatementGenerator.helpers.PreparedStatementGenerator.interfaces.PreparedStatementGenerator;
import com.projectk.storage.storageManager.implementations.helpers.executableStatementGenerator.helpers.sqlQueryGenerators.implementations.SearchSubjectWildCardSqlQueryGenerator;
import com.projectk.storage.storageManager.implementations.helpers.executableStatementGenerator.helpers.sqlQueryGenerators.interfaces.WildCardSqlQueryGenerator;
import com.projectk.storage.storageManager.interfaces.StorageManager;

import java.sql.*;
import java.util.List;

public class SubjectManager implements StorageManager<Subject, SearchSubject> {
    private ConnectionManager connectionManager;

    public SubjectManager(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public static void main(String[] args) throws SQLException, StorageException {
        SubjectManager m = new SubjectManager(new MysqlConnectionManager());
        String name="CALCULUS 1";
        m.filter(new SearchSubject.Builder().subjectName(name).build());
    }

    @Override
    public List<Subject> filter(SearchSubject searchEntity) throws StorageException, SQLException {
        Connection connection = null;
        try {
            connection = connectionManager.getConnection();
            PreparedStatementGenerator statementGenerator = new SearchSubjectPreparedStatementGenerator(connection);
            WildCardSqlQueryGenerator sqlQueryGenerator = new SearchSubjectWildCardSqlQueryGenerator();
            String query = sqlQueryGenerator.generateWildCardQueryFromSearchEntity(searchEntity);
            PreparedStatement statement = (PreparedStatement) statementGenerator.generatePreparedStatementFromSqlQuery(query, searchEntity);
            ResultSet set = statement.executeQuery();
            while(set.next()) {
                int a = set.getInt(1);
            }
        } catch (SQLException throwables) {
            throw new StorageException(throwables);
        }
        return null;
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
