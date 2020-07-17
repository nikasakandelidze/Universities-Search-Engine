package com.projectk.entities.searchEntities;


import com.projectk.entities.FacultyCategory;

public class SearchUniversity {

    private FacultyCategory facultyCategory;

    private String universityName;

    private Integer universityId;

    private String city;

    public FacultyCategory getFacultyCategory() {
        return facultyCategory;
    }

    public void setFacultyCategory(FacultyCategory facultyCategory) {
        this.facultyCategory = facultyCategory;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public Integer getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Integer universityId) {
        this.universityId = universityId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public static class Builder{
        private FacultyCategory faculty;

        private String universityName;

        private Integer universityId;

        private String city;

        public SearchUniversity.Builder universityId(Integer val){
            universityId=val;
            return this;
        }
        public SearchUniversity.Builder faculty(FacultyCategory fac){
            faculty=fac;
            return this;
        }
        public SearchUniversity.Builder city(String cityVal){
            city=cityVal;
            return this;
        }
        public SearchUniversity.Builder universityName(String UniName){
            universityName = UniName;
            return this;
        }
    }

    private SearchUniversity(SearchUniversity.Builder builder){
        this.facultyCategory = builder.faculty;
        this.city = builder.city;
        this.universityId = builder.universityId;
        this.universityName = builder.universityName;
    }
}
