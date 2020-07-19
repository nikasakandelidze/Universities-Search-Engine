package com.projectk.storage.storageManager.implementations.subjectManager.executableStatementGenerator.helpers.sqlQueryGenerators.interfaces;

public interface WildCardSqlQueryGenerator<T> {
    String generateWildCardQueryFromSearchEntity(T searchEntity);
}
