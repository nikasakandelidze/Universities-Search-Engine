package com.projectk.storage.storageManager.implementations.facultystorage;

import com.projectk.entities.Faculty;
import com.projectk.entities.enums.FacultyCategory;
import com.projectk.entities.searchEntities.SearchFaculty;
import com.projectk.storage.storageManager.implementations.facultystorage.statementbuilders.FacultySelectStatementBuilder;
import com.projectk.storage.storageManager.implementations.facultystorage.statementbuilders.FacultyUpdateStatementBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
				.price(rs.getLong(COLUMNS[5]))
				.description(rs.getString(COLUMNS[6]))
				.webpage(rs.getString(COLUMNS[7]))
				.build();
	}

	public static FacultyCategory getCategory(String category) {
		switch (category) {
			case "BUSINESS":
				return FacultyCategory.BUSINESS;
			case "COMPUTERSCIENCE":
				return FacultyCategory.COMPUTERSCIENCE;
			case "ENGINEERING":
				return FacultyCategory.ENGINEERING;
			case "PSYCHOLOGY":
				return FacultyCategory.PSYCHOLOGY;
			case "LAW":
				return FacultyCategory.LAW;
			case "MEDICINE":
				return FacultyCategory.MEDICINE;
			case "PHILOSOPHY":
				return FacultyCategory.PHILOSOPHY;
		}
		return null;
	}

	public static PreparedStatement getSelectStatement (SearchFaculty searchFaculty, Connection connection) throws SQLException {
		return new FacultySelectStatementBuilder(connection)
				.byCategory(searchFaculty.getFacultyCategory())
				.byMinPrice(searchFaculty.getMinPrice())
				.byMaxPrice(searchFaculty.getMaxPrice())
				.byUniversityId(searchFaculty.getUniversityID())
				.build();
	}

	public static PreparedStatement getUpdateStatement (Faculty faculty, Connection connection) throws SQLException {
		return new FacultyUpdateStatementBuilder(connection)
				.byCategory(faculty.getCategory())
				.byDeanInfo(faculty.getDeanInfo())
				.byDescription(faculty.getDescription())
				.byname(faculty.getName())
				.byPrice(faculty.getPrice())
				.byWebPage(faculty.getWebPageLink())
				.where(faculty.getFacultyId())
				.build();
	}

	public static PreparedStatement getFindStatement (Integer facultyId, Connection connection) throws SQLException {
		return new FacultySelectStatementBuilder(connection)
				.byFacultyId(facultyId)
				.build();
	}

}
