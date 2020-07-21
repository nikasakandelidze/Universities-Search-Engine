package com.projectk.storage.storageManager.implementations.facultystorage.statementbuilders;

import com.projectk.entities.Faculty;
import com.projectk.entities.enums.FacultyCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacultyUpdateStatementBuilder {
	private Connection conn;
	private StringBuilder query = new StringBuilder("UPDATE Faculty f SET ");
	private List<ValueSetter> valueSetters = new ArrayList<ValueSetter>();
	private int parameterCounter;

	private interface ValueSetter {
		void setValue(PreparedStatement ps) throws SQLException;
	}

	public FacultyUpdateStatementBuilder(Connection conn) {
		this.conn = conn;
		parameterCounter = 1;
	}

	public FacultyUpdateStatementBuilder byCategory(final FacultyCategory category) {
		if (category == null) {
			return this;
		}
		query.append("f.category = ?");
		appendSeparator();
		valueSetters.add(new ValueSetter() {
			public void setValue(PreparedStatement ps) throws SQLException {
				ps.setString(parameterCounter, category.name());
				parameterCounter++;
			}
		});
		return this;
	}

	public FacultyUpdateStatementBuilder byname(final String name) {
		if (name == null) {
			return this;
		}
		query.append("f.name = ?");
		appendSeparator();
		valueSetters.add(new ValueSetter() {
			public void setValue(PreparedStatement ps) throws SQLException {
				ps.setString(parameterCounter, name);
				parameterCounter++;
			}
		});
		return this;
	}

	public FacultyUpdateStatementBuilder byDeanInfo(final String deanInfo) {
		if (deanInfo == null) {
			return this;
		}
		query.append("f.dean_info = ?");
		appendSeparator();
		valueSetters.add(new ValueSetter() {
			public void setValue(PreparedStatement ps) throws SQLException {
				ps.setString(parameterCounter, deanInfo);
				parameterCounter++;
			}
		});
		return this;
	}

	public FacultyUpdateStatementBuilder byPrice(final Long price) {
		if (price == null) {
			return this;
		}
		query.append("f.price = ?");
		appendSeparator();
		valueSetters.add(new ValueSetter() {
			public void setValue(PreparedStatement ps) throws SQLException {
				ps.setLong(parameterCounter, price);
				parameterCounter++;
			}
		});
		return this;
	}

	public FacultyUpdateStatementBuilder byDescription(final String description) {
		if (description == null) {
			return this;
		}
		query.append("f.description = ?");
		appendSeparator();
		valueSetters.add(new ValueSetter() {
			public void setValue(PreparedStatement ps) throws SQLException {
				ps.setString(parameterCounter, description);
				parameterCounter++;
			}
		});
		return this;
	}

	public FacultyUpdateStatementBuilder byWebPage(final String web) {
		if (web == null) {
			return this;
		}
		query.append("f.web_page_link = ?");
		appendSeparator();
		valueSetters.add(new ValueSetter() {
			public void setValue(PreparedStatement ps) throws SQLException {
				ps.setString(parameterCounter, web);
				parameterCounter++;
			}
		});
		return this;
	}

	public FacultyUpdateStatementBuilder where(final Integer id) {
		if (id == null) {
			return this;
		}
		adjustQuery();
		appendWhere();
		query.append("f.faculty_id = ?");
		valueSetters.add(new ValueSetter() {
			public void setValue(PreparedStatement ps) throws SQLException {
				ps.setInt(parameterCounter, id);
				parameterCounter++;
			}
		});
		return this;
	}

	private void adjustQuery() {
		int i = query.lastIndexOf(",");
		query.replace(i,i+1,"");
	}

	private void appendWhere() {
		query.append(" WHERE ");
	}

	private void appendSeparator() {
		query.append(" , ");
	}

	public PreparedStatement build() throws SQLException {
		PreparedStatement ps = conn.prepareStatement(query.toString());
		for(ValueSetter valueSetter : valueSetters) {
			valueSetter.setValue(ps);
		}

		return ps;
	}
}
