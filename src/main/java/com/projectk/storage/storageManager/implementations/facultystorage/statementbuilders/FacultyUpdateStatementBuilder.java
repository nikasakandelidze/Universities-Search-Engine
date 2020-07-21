package com.projectk.storage.storageManager.implementations.facultystorage.statementbuilders;

import com.projectk.entities.Faculty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FacultyUpdateStatementBuilder {
	private Connection conn;
	Faculty faculty;

	public FacultyUpdateStatementBuilder(Connection conn, Faculty faculty) {
		this.conn = conn;
		this.faculty = faculty;
	}

	private String getQuery() {
		return "DELETE FROM Faculty WHERE faculty_id=?";
	}

	public PreparedStatement build() throws SQLException {
		PreparedStatement ps = conn.prepareStatement(getQuery());
		ps.setInt(1, faculty.getFacultyId());
		return ps;
	}
}
