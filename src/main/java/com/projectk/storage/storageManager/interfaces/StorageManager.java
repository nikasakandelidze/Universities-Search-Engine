package com.projectk.storage.storageManager.interfaces;

import com.projectk.storage.connectionManager.customExceptions.StorageException;

import java.sql.SQLException;
import java.util.List;

public interface StorageManager<T, Q> {
	List<T> filter(Q searchEntity) throws SQLException, StorageException;

	void add(T entity);

	void delete(T entity);

	void update(T entity);
}
