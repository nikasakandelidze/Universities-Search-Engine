package com.projectk.storage.storageManager.implementations.subjectManager.executableStatementGenerator;

import com.projectk.storage.connectionManager.customExceptions.StorageException;

public interface ExecutableStatementGenerator<T, Q> {
    Object getSelectExecutableStatement(T searchEntity) throws StorageException;

    Object getAddExecutableStatement(Q newEntity);

    Object getUpdateExecutableStatement(Q newEntity);

    Object getDeleteExecutableStatement(int id);
}
