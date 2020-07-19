package com.projectk.storage.storageManager.implementations.facultystorage;

import com.projectk.entities.enums.FacultyCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacultySelectStatementBuilder {
	private Connection conn;
	private StringBuilder query = new StringBuilder("SELECT * FROM faculty f WHERE 1=1");
	private List<ValueSetter> valueSetters = new ArrayList<ValueSetter>();
	private int parameterCounter;

	private interface ValueSetter {
		void setValue(PreparedStatement ps) throws SQLException;
	}

	public FacultySelectStatementBuilder(Connection conn) {
		this.conn = conn;
		parameterCounter = 1;
	}

	public FacultySelectStatementBuilder byUniversityId(final Integer id) {
		if (id == null) {
			return this;
		}
		appendSeparator();
		query.append("f.university_id = ?");
		valueSetters.add(new ValueSetter() {
			public void setValue(PreparedStatement ps) throws SQLException {
				ps.setInt(parameterCounter, id);
				parameterCounter++;
			}
		});
		return this;
	}

	public FacultySelectStatementBuilder byCategory(final FacultyCategory category) {
		if (category == null) {
			return this;
		}
		appendSeparator();
		query.append("f.category = ?");
		valueSetters.add(new ValueSetter() {
			public void setValue(PreparedStatement ps) throws SQLException {
				ps.setString(parameterCounter, category.name());
				parameterCounter++;
			}
		});
		return this;
	}

	public FacultySelectStatementBuilder byMinPrice(final Long price) {
		if (price == null) {
			return this;
		}
		appendSeparator();
		query.append("f.price >= ?");
		valueSetters.add(new ValueSetter() {
			public void setValue(PreparedStatement ps) throws SQLException {
				ps.setLong(parameterCounter, price);
				parameterCounter++;
			}
		});
		return this;
	}

	public FacultySelectStatementBuilder byMaxPrice(final Long price) {
		if (price == null) {
			return this;
		}
		appendSeparator();
		query.append("f.price <= ?");
		valueSetters.add(new ValueSetter() {
			public void setValue(PreparedStatement ps) throws SQLException {
				ps.setLong(parameterCounter, price);
				parameterCounter++;
			}
		});
		return this;
	}

	private void appendSeparator() {
			query.append(" AND ");
	}

	public PreparedStatement build() throws SQLException {
		PreparedStatement ps = conn.prepareStatement(query.toString());
		for(ValueSetter valueSetter : valueSetters) {
			valueSetter.setValue(ps);
		}
		return ps;
	}
}
