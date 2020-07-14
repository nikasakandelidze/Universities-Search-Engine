package com.projectk.storage.interfaces.helpers;

import com.projectk.entities.Subject;
import com.projectk.entities.searchEntities.SearchSubject;

import java.util.List;

public interface SubjectStorage {
    List<Subject> filterSubject(SearchSubject searchSubject);

    void addSubject(Subject subject);

    void deleteSubject(Subject subject);

    void updateSubject(Subject subject);
}
