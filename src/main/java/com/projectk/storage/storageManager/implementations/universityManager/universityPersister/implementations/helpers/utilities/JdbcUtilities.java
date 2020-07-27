package com.projectk.storage.storageManager.implementations.universityManager.universityPersister.implementations.helpers.utilities;

import com.projectk.entities.University;
import com.projectk.storage.connectionManager.customExceptions.StorageException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcUtilities {
    public static List<University> getListOfUniversities(ResultSet resultSet) throws StorageException {
        List<University> universities = new ArrayList<>();
        try {
            while (resultSet.next()) {
                universities.add(getUniversity(resultSet));
            }
        } catch (SQLException throwables) {
            throw new StorageException(throwables);
        }
        return universities;
    }

    private static University getUniversity(ResultSet resultUnit) throws StorageException {
        University university = new University();
        try {
            university.setId(resultUnit.getInt("id"));
            university.setCity(resultUnit.getString("city"));
            university.setUniversityName(resultUnit.getString("university_name"));
            university.setAddress(resultUnit.getString("address"));
            university.setWebPageLink(resultUnit.getString("web_page_link"));
            university.setDescriptions(resultUnit.getString("descriptions"));
            university.setUsername(resultUnit.getString("username"));
        } catch (SQLException throwables) {
            throw new StorageException(throwables);
        }
        return university;
    }
}
