package com.projectk.entities;

@SuppressWarnings("unused")
public class University {
	private int id;

	private String universityName;

	private String city;

	private String address;

	private String webPageLink;

	private String descriptions;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWebPageLink() {
		return webPageLink;
	}

	public void setWebPageLink(String webPageLink) {
		this.webPageLink = webPageLink;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
}
