package com.projectk.storage.storageManager.implementations.facultystorage;

import com.projectk.entities.Faculty;
import com.projectk.entities.enums.FacultyCategory;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FacultyUtils {
	public static final String[] COLUMNS = {"faculty_id",
			"category",
			"university_id",
			"name",
			"dean_info",
			"price",
			"description",
			"web_page_link"};

	public static Faculty getFaculty(ResultSet rs) throws SQLException {
		return new Faculty.Builder()
				.facultyId(rs.getInt(COLUMNS[0]))
				.category(getCategory(rs.getString(COLUMNS[1])))
				.universityId(rs.getInt(COLUMNS[2]))
				.name(rs.getString(COLUMNS[3]))
				.deanInfo(rs.getString(COLUMNS[4]))
				.price(rs.getString(COLUMNS[5]))
				.description(rs.getString(COLUMNS[6]))
				.webpage(rs.getString(COLUMNS[7]))
				.build();
	}

	public static FacultyCategory getCategory(String category) {
		switch (category) {
			case "BUSINESS":
				return FacultyCategory.BUSINESS;
			case "CS":
				return FacultyCategory.CS;
			case "ENGINEERING":
				return FacultyCategory.ENGINEERING;
		}
		return null;
	}
}
