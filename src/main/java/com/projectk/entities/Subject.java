package com.projectk.entities;


public class Subject {

    private int subjectId;

    private int facultyId;

    private String subjectName;

    private int credits;

    private String descriptions;

    private int semester;

    public Subject() {
    }

    private Subject(Subject.Builder builder) {
        this.subjectId = builder.subjectId;
        this.facultyId = builder.facultyId;
        this.subjectName = builder.subject_name;
        this.credits = builder.credits;
        this.descriptions = builder.descriptions;
        this.semester = builder.semester;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "Subject{" + "subjectId=" + subjectId + ", facultyId=" + facultyId + ", subjectName=" + subjectName + ", credits='" + credits + '\'' + ", descriptions='" + descriptions + '\'' + ", semester='" + semester + '\'' + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Subject) {
            Subject element = (Subject) obj;
            if (element != null && this.subjectId == (element.getSubjectId()) && this.subjectName.equals(element.getSubjectName()) && this.facultyId == element.getFacultyId() && this.credits == element.getCredits() && this.descriptions.equals(element.getDescriptions()) && this.semester == element.getSemester()) {
                return true;
            }
        }
        return false;
    }

    public static class Builder {
        private Integer subjectId;
        private Integer facultyId;
        private String subject_name;
        private Integer credits;
        private String descriptions;
        private Integer semester;


        public Subject.Builder subject_id(Integer val) {
            subjectId = val;
            return this;
        }

        public Subject.Builder faculty_id(Integer val) {
            facultyId = val;
            return this;
        }

        public Subject.Builder subject_name(String val) {
            subject_name = val;
            return this;
        }

        public Subject.Builder credits(Integer val) {
            credits = val;
            return this;
        }

        public Subject.Builder descriptions(String val) {
            descriptions = val;
            return this;
        }

        public Subject.Builder semester(Integer val) {
            semester = val;
            return this;
        }

        public Subject build() {
            return new Subject(this);
        }
    }
}
