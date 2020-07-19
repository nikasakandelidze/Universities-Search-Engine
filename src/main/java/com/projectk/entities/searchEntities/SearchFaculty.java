package com.projectk.entities.searchEntities;

import com.projectk.entities.enums.FacultyCategory;

public class SearchFaculty implements SearchEntity{

	private Integer universityID;

	private FacultyCategory facultyCategory;

	private Long minPrice;

	private Long maxPrice;

	public Integer getUniversityID() {
		return universityID;
	}

	public FacultyCategory getFacultyCategory() {
		return facultyCategory;
	}

	public Long getMinPrice() {
		return minPrice;
	}

	public Long getMaxPrice() {
		return maxPrice;
	}

	public static class Builder {
		private Integer universityID;
		private FacultyCategory category;
		private Long minPrice;
		private Long maxPrice;

		public Builder universityId(Integer val) {
			universityID = val;
			return this;
		}

		public Builder category(FacultyCategory val) {
			category = val;
			return this;
		}

		public Builder minPrice(Long val1) {
			minPrice = val1;
			return this;
		}

		public Builder maxPrice(Long val1) {
			maxPrice = val1;
			return this;
		}

		public SearchFaculty build() {
			return new SearchFaculty(this);
		}
	}

	private SearchFaculty(Builder builder) {
		this.universityID = builder.universityID;
		this.facultyCategory = builder.category;
		this.minPrice = builder.minPrice;
		this.maxPrice = builder.maxPrice;
	}
}
