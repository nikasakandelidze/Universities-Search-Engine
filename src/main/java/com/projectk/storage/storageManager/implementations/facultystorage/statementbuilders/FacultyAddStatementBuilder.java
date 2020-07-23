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
		for (int i = 0; i < FIELD_COUNT; i++) {
			query.append(FacultyUtils.COLUMNS[i]);
			if (i < FIELD_COUNT - 1) {
				query.append(", ");
			}
		}
		query.append(") VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
		return query.toString();
	}

	public PreparedStatement build() throws SQLException {
		PreparedStatement ps = conn.prepareStatement(getQuery());
		ps.setInt(1, faculty.getFacultyId());
		ps.setString(2, faculty.getCategory().name());
		ps.setInt(3, faculty.getUniversityId());
		ps.setString(4, faculty.getName());
		ps.setString(5, faculty.getDeanInfo());
		ps.setLong(6,faculty.getPrice());
		ps.setString(7, faculty.getDescription());
		ps.setString(8, faculty.getWebPageLink());
		return ps;
	}
}
