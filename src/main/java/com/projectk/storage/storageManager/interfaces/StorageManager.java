package com.projectk.storage.storageManager.interfaces;

import com.projectk.entities.University;
import com.projectk.storage.connectionManager.customExceptions.StorageException;

import jdk.jshell.spi.ExecutionControl;

import java.util.List;
import java.util.Optional;

public interface StorageManager<T, Q> {
    List<T> filter(Q searchEntity) throws StorageException;

    void add(T entity) throws StorageException;

    void delete(T entity) throws StorageException;

    void update(T entity) throws StorageException;

    Optional<T> find(int id) throws StorageException, ExecutionControl.NotImplementedException, Exception;
}
