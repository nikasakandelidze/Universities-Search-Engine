package com.projectk.storage.storageManager.implementations.facultystorage.statementbuilders;

import com.projectk.entities.Faculty;
import com.projectk.entities.enums.FacultyCategory;
import com.projectk.storage.storageManager.implementations.facultystorage.FacultyUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FacultyAddStatementBuilder {
	private Connection conn;
	Faculty faculty;
	private static int FIELD_COUNT = 8;

	public FacultyAddStatementBuilder(Connection conn, Faculty faculty) {
		this.conn = conn;
		this.faculty = faculty;
	}

	private String getQuery() {
		StringBuilder query = new StringBuilder("INSERT INTO Faculty ");
		query.append("(");
		for (int i = 1; i < FIELD_COUNT; i++) {
			query.append(FacultyUtils.COLUMNS[i]);
			if (i < FIELD_COUNT - 1) {
				query.append(", ");
			}
		}
		query.append(") VALUES(?, ?, ?, ?, ?, ?, ?)");
		return query.toString();
	}

	public PreparedStatement build() throws SQLException {
		PreparedStatement ps = conn.prepareStatement(getQuery());
		ps.setString(1, faculty.getCategory().name());
		ps.setInt(2, faculty.getUniversityId());
		ps.setString(3, faculty.getName());
		ps.setString(4, faculty.getDeanInfo());
		ps.setLong(5, faculty.getPrice());
		ps.setString(6, faculty.getDescription());
		ps.setString(7, faculty.getWebPageLink());
		return ps;
	}
}
