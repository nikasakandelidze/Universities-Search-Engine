package com.projectk.storage.storageManager.implementations.ORM;

import java.util.List;

public interface ObjectRelationalMapping<T,Q> {
    List<T> filter(Q searchEntity);
    T add(Q entity);
    T delete(T entity);
    T update(T entity);
}
