package com.projectk.storage.storageManager.implementations.universityManager.universityPersister.interfaces;

import com.projectk.entities.University;
import com.projectk.entities.searchEntities.SearchUniversity;
import com.projectk.storage.connectionManager.customExceptions.StorageException;

import java.sql.Connection;
import java.util.List;

public interface UniversityPersister {
    List<University> filter(Connection connection, SearchUniversity searchEntity) throws StorageException;
    University add(Connection connection, University entity) throws StorageException;
    University update(Connection connection, University entity) throws StorageException;
    University delete(Connection connection, University entity) throws StorageException;
}
