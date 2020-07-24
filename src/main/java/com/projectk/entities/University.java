package com.projectk.entities;

public class University {

	private int id;

	private String universityName;

	private String city;

	private String address;

	private String webPageLink;

	private String descriptions;

	private String username;

	public University(){}

	private University(Builder builder){
		this.universityName = builder.universityName;
		this.city = builder.city;
		this.address = builder.address;
		this.webPageLink = builder.webPageLink;
		this.descriptions = builder.descriptions;
		this.id = builder.id;
		this.username = builder.username;
	}
	public String getUsername() {
		return username;
	}

    public void setUsername(String username) {
        this.username = username;
    }

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

	@Override
	public String toString() {
		return "University{" + "id=" + id + ", universityName='" + universityName + '\'' + ", city='" + city + '\'' + ", address='" + address + '\'' + ", webPageLink='" + webPageLink + '\'' + ", descriptions='" + descriptions + '\'' + ", username='" + username + '\'' + '}';
	}

	@Override
	public boolean equals(Object o){
		University university = (University) o;
		return university.username.equals(this.username) &&
				university.universityName.equals(this.universityName) &&
				 university.descriptions.equals(this.descriptions) &&
				  university.webPageLink.equals(this.webPageLink) &&
				   university.address.equals(this.address) &&
				    university.city.equals(this.city);
	}

	public static class Builder{
		private int id;

		private String universityName;

		private String city;

		private String address;

		private String webPageLink;

		private String descriptions;

		private String username;

		public Builder withId(int id){
			this.id = id;
			return this;
		}

		public Builder withName(String name){
			this.universityName = name;
			return this;
		}

		public Builder withCity(String city){
			this.city = city;
			return this;
		}

		public Builder withAddress(String address){
			this.address = address;
			return this;
		}

		public Builder withWebPageLink(String webPageLink){
			this.webPageLink = webPageLink;
			return this;
		}

		public Builder withDescriptions(String descriptions){
			this.descriptions = descriptions;
			return this;
		}

		public Builder withUserName(String username){
			this.username = username;
			return this;
		}

		public University build(){
			return new University(this);
		}
	}

}
