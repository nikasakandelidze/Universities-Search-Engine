package com.projectk.storage.storageManager.implementations.subject.executableStatementGenerator.helpers.sqlQueryGenerators.interfaces;

public interface WildCardSqlQueryGenerator<T> {
    String generateWildCardQueryFromSearchEntity(T searchEntity);
}
