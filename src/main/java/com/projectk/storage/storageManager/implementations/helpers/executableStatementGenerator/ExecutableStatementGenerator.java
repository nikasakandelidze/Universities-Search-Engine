package com.projectk.storage.storageManager.implementations.helpers.executableStatementGenerator;

import com.projectk.storage.connectionManager.customExceptions.StorageException;

public interface ExecutableStatementGenerator<T> {
    Object getExecutableStatement(T searchEntity) throws StorageException;
}
