package com.projectk.storage.storageManager.implementations.subjectManager;

import com.projectk.entities.Subject;
import com.projectk.entities.searchEntities.SearchSubject;
import com.projectk.storage.connectionManager.ConnectionManager;
import com.projectk.storage.connectionManager.MysqlConnectionManager;
import com.projectk.storage.connectionManager.customExceptions.StorageException;
import com.projectk.storage.storageManager.implementations.subjectManager.executableStatementGenerator.helpers.sqlQueryGenerators.interfaces.WildCardSqlQueryGenerator;
import com.projectk.storage.storageManager.interfaces.StorageManager;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;
@Repository
public class SubjectManager implements StorageManager<Subject, SearchSubject> {
    private ConnectionManager connectionManager;

    public SubjectManager(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public static void main(String[] args) throws SQLException, StorageException {
        SubjectManager m = new SubjectManager(new MysqlConnectionManager());
        String name = "CALCULUS 1";
        //m.filter(new SearchSubject.Builder().subjectName(name).build());
        Subject entity = new Subject();
        entity.setSemester(6);
        entity.setDescriptions("test");
        entity.setCredits(6);
        entity.setSubjectName("test");
        entity.setFacultyId(121);
        entity.setSubjectId(121);
        String a = "INSERT INTO university_subject ";
        a+= "VALUES(";
        a += entity.getSubjectId() + ", ";
        a += entity.getFacultyId() + ", ";
        a += "'"+entity.getSubjectName() +"'"+ ", ";
        a += entity.getCredits() + ", ";
        a += "'"+entity.getDescriptions()+"'" + ", ";
        a += entity.getSemester() + ")";
        System.out.println(a);
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
            while (set.next()) {
                int a = set.getInt(1);
                System.out.println(a);
            }
        } catch (SQLException throwables) {
            throw new StorageException(throwables);
        }
        return null;
    }

    private String insertValues(Subject entity) {
        String ans = "VALUES(";
        ans += entity.getSubjectId() + ", ";
        ans += entity.getFacultyId() + ", ";
        ans += "'"+entity.getSubjectName() +"'"+ ", ";
        ans += entity.getCredits() + ", ";
        ans += "'"+entity.getDescriptions()+"'" + ", ";
        ans += entity.getSemester() + ")";
        return ans;
    }

    @Override
    public void add(Subject entity) {
        Connection connection = null;
        try {
            connection = connectionManager.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO university_subject " + insertValues(entity));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void delete(Subject entity) {
        Connection connection = null;
        try {
            connection = connectionManager.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM university_subject WHERE subject_id=" + entity.getSubjectId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(Subject entity) {
        Connection connection = null;
        try {
            connection = connectionManager.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE university_subject SET " + updateValues(entity));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private String updateValues(Subject entity) {
        String ans = "";
        ans += "faculty_id=" + entity.getFacultyId() + " and ";
        ans += "subject_name=" + "'"+entity.getSubjectName()+"'" + " and ";
        ans += "credits=" + entity.getCredits() + " and ";
        ans += "descriptions=" + "'"+entity.getDescriptions()+ "'"+ " and ";
        ans += "semester=" + entity.getSemester();
        ans += " WHERE subject_id=" + entity.getSubjectId();
        return ans;
    }
}
