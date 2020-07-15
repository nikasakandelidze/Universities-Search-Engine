package com.projectk.entities;

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
}
