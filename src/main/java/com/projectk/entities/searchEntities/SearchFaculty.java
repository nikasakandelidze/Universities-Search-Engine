package com.projectk.entities.searchEntities;

import com.projectk.entities.enums.FacultyCategory;

public class SearchFaculty {

    private String name;

    private Integer universityID;

    private FacultyCategory facultyCategory;

    private Long minPrice;

    private Long maxPrice;

    public static SearchFaculty selectAll() {
        return new SearchFaculty.Builder().build();
    }

    public static SearchFaculty selectFacultyWithUniversityId(int id) {
        return new SearchFaculty.Builder().universityId(id).build();
    }

    public static SearchFaculty selectFacultyWithCategory(FacultyCategory facultyCategory) {
        return new SearchFaculty.Builder().category(facultyCategory).build();
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class Builder {
        private String name;
        private Integer universityID;
        private FacultyCategory category;
        private Long minPrice;
        private Long maxPrice;

        public Builder name(String val) {
            name = val;
            return this;
        }

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
        this.name = builder.name;
        this.universityID = builder.universityID;
        this.facultyCategory = builder.category;
        this.minPrice = builder.minPrice;
        this.maxPrice = builder.maxPrice;
    }
}
