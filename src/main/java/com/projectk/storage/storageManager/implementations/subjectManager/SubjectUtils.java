package com.projectk.storage.storageManager.implementations.subjectManager;

import com.projectk.entities.Faculty;
import com.projectk.entities.Subject;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.projectk.storage.storageManager.implementations.facultystorage.FacultyUtils.getCategory;

public class SubjectUtils {
    public static final String[] COLUMNS = {"subject_id",
            "faculty_id",
            "subject_name",
            "credits",
            "descriptions",
            "semester"};

    public static Subject getSubject(ResultSet rs) throws SQLException {
        return new Subject.Builder()
                .subject_id(rs.getInt(COLUMNS[0]))
                .faculty_id((rs.getInt(COLUMNS[1])))
                .subject_name(rs.getString(COLUMNS[2]))
                .credits(rs.getInt(COLUMNS[3]))
                .descriptions(rs.getString(COLUMNS[4]))
                .semester(rs.getInt(COLUMNS[5]))
                .build();
    }
}
