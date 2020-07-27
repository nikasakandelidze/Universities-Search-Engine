package com.projectk.entities.searchEntities;

public class SearchSubject {

    private Integer universityId;

    private Integer facultyId;

    private String subjectName;

    public SearchSubject() {

    }

    public static SearchSubject selectAll(){
        return new SearchSubject.Builder().build();
    }

    public Integer getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Integer universityId) {
        this.universityId = universityId;
    }

    public Integer getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Integer facultyId) {
        this.facultyId = facultyId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public static class Builder{
        private Integer universityId;

        private Integer facultyId;

        private String subjectName;

        public Builder universityId(Integer val){
            universityId=val;
            return this;
        }
        public Builder facultyId(Integer val){
            facultyId=val;
            return this;
        }
        public Builder subjectName(String val){
            subjectName=val;
            return this;
        }
        public Builder universityFaculty(Integer un_id,Integer fa_id){
            universityId=un_id;
            facultyId=fa_id;
            return this;
        }

        public SearchSubject build() {
            return new SearchSubject(this);
        }

    }

    public SearchSubject(Builder builder){
        this.universityId=builder.universityId;
        this.facultyId=builder.facultyId;
        this.subjectName=builder.subjectName;
    }
}
