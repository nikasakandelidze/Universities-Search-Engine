package com.projectk;


import com.projectk.entities.Subject;
import com.projectk.entities.searchEntities.SearchSubject;
import com.projectk.entities.searchEntities.SearchUniversity;
import com.projectk.storage.connectionManager.ConnectionManager;
import com.projectk.storage.connectionManager.MysqlConnectionManager;
import com.projectk.storage.connectionManager.customExceptions.StorageException;
import com.projectk.storage.storageManager.implementations.subjectManager.SubjectManager;
import com.projectk.storage.storageManager.implementations.subjectManager.SubjectManager;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class subjectTest {
    @Test
    public void testSubject() {
        ConnectionManager connectionManager = new MysqlConnectionManager();
        SubjectManager subjectManager = new SubjectManager(connectionManager);

        Subject subject1 = new Subject();
        subject1.setCredits(4);
        subject1.setSubjectId(12);
        subject1.setSubjectName("linear algebra");
        subject1.setSemester(3);
        subject1.setFacultyId(24);
        subject1.setDescriptions("this course encapsules the roots of linear algebra");
        assertEquals(4, subject1.getCredits());
        assertEquals(12, subject1.getSubjectId());
        assertEquals("linear algebra", subject1.getSubjectName());
        assertEquals(3, subject1.getSemester());
        assertEquals(24, subject1.getFacultyId());
        assertEquals("this course encapsules the roots of linear algebra", subject1.getDescriptions());

        Subject subject2 = new Subject();
        subject2.setCredits(5);
        subject2.setSubjectId(13);
        subject2.setSubjectName("Kalkulus");
        subject2.setSemester(1);
        subject2.setFacultyId(25);
        subject2.setDescriptions("this course encapsules the roots of Kalkulus");
        assertEquals(5, subject2.getCredits());
        assertEquals(13, subject2.getSubjectId());
        assertEquals("Kalkulus", subject2.getSubjectName());
        assertEquals(1, subject2.getSemester());
        assertEquals(25, subject2.getFacultyId());
        assertEquals("this course encapsules the roots of Kalkulus", subject2.getDescriptions());

        Subject subject3 = new Subject();
        subject3.setCredits(2);
        subject3.setSubjectId(7);
        subject3.setSubjectName("Excel for business");
        subject3.setSemester(5);
        subject3.setFacultyId(23);
        subject3.setDescriptions("this course encapsules the roots of Excel");
        assertEquals(2, subject3.getCredits());
        assertEquals(7, subject3.getSubjectId());
        assertEquals("Excel", subject3.getSubjectName());
        assertEquals(5, subject3.getSemester());
        assertEquals(23, subject3.getFacultyId());
        assertEquals("this course encapsules the roots of Excel", subject3.getDescriptions());


    }

    public void testSubjectManager(Subject subject) {
        ConnectionManager connectionManager = new MysqlConnectionManager();
        SubjectManager subjectManager = new SubjectManager(connectionManager);

        subjectManager.add(subject);
        SearchSubject searchEntity = new SearchSubject.Builder().subjectName("linear algebra").build();
        try {
            subjectManager.filter(searchEntity);
        } catch (StorageException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Subject> list = new ArrayList<>();
        try {
            list = subjectManager.filter(searchEntity);
        } catch (StorageException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < list.size(); i++) {
            Subject subj = list.get(i);
            assertEquals(subj.getSubjectName(), "linear algebra");
        }
        subjectManager.delete(subject);
        try {
            list = subjectManager.filter(searchEntity);
        } catch (StorageException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < list.size(); i++) {
            Subject subj = list.get(i);
            assertNull(subj.getSubjectName(), "linear algebra");
        }

    }

}
