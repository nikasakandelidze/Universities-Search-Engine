package com.projectk.entities;

import com.projectk.entities.enums.FacultyCategory;

public class Faculty {

	private int facultyId;

	private FacultyCategory category;

	private int universityId;

	private String name;

	private String deanInfo;

	private String price;

	private String description;

	private String webPageLink;

	public int getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}

	public FacultyCategory getCategory() {
		return category;
	}

	public void setCategory(FacultyCategory category) {
		this.category = category;
	}

	public int getUniversityId() {
		return universityId;
	}

	public void setUniversityId(int universityId) {
		this.universityId = universityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeanInfo() {
		return deanInfo;
	}

	public void setDeanInfo(String deanInfo) {
		this.deanInfo = deanInfo;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWebPageLink() {
		return webPageLink;
	}

	public void setWebPageLink(String webPageLink) {
		this.webPageLink = webPageLink;
	}

	public static class Builder {
		private int facultyId;
		private FacultyCategory category;
		private int universityId;
		private String name;
		private String deanInfo;
		private String price;
		private String description;
		private String webPageLink;

		public Builder facultyId(Integer val) {
			facultyId = val;
			return this;
		}

		public Builder category(FacultyCategory val) {
			category = val;
			return this;
		}

		public Builder universityId(Integer val) {
			universityId = val;
			return this;
		}

		public Builder name(String val) {
			name = val;
			return this;
		}

		public Builder deanInfo(String val) {
			deanInfo = val;
			return this;
		}

		public Builder price(String val) {
			price = val;
			return this;
		}

		public Builder description(String val) {
			description = val;
			return this;
		}

		public Builder webpage(String val) {
			webPageLink = val;
			return this;
		}

		public Faculty build() {
			return new Faculty(this);
		}
	}

	private Faculty(Builder builder) {
		this.facultyId = builder.facultyId;
		this.category = builder.category;
		this.universityId = builder.universityId;
		this.name = builder.name;
		this.deanInfo = builder.deanInfo;
		this.price = builder.price;
		this.description = builder.description;
		this.webPageLink = builder.webPageLink;
	}

	@Override
	public String toString() {
		return "Faculty{" +
				"facultyId=" + facultyId +
				", category=" + category +
				", universityId=" + universityId +
				", name='" + name + '\'' +
				", deanInfo='" + deanInfo + '\'' +
				", price='" + price + '\'' +
				", description='" + description + '\'' +
				", webPageLink='" + webPageLink + '\'' +
				'}';
	}
}
