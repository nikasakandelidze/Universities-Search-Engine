package com.projectk.storage.storageManager.implementations.ORM;

import java.util.List;

public interface ObjectRelationalMapping<T> {
    List<?> filter(T searchEntity);
    T add(T entity);
    T delete(T entity);
    T update(T entity);
}
