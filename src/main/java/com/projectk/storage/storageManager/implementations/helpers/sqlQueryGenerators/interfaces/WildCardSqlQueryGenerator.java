package com.projectk.storage.storageManager.implementations.helpers.sqlQueryGenerators.interfaces;

public interface WildCardSqlQueryGenerator<T> {
    String generateWildCardQueryFromSearchEntity(T searchEntity);
}
