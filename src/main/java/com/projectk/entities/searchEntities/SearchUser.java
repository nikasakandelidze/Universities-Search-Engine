package com.projectk.entities.searchEntities;

public class SearchUser {

    private String username;

    public SearchUser() {

    }


    public String getUserName() {
        return username;
    }

    public void setUsername(String universityId) {
        this.username = username;
    }


    public static class Builder{

        private String userName;

        public SearchUser.Builder userName(String  val){
            userName=val;
            return this;
        }

        public SearchUser build() {
            return new SearchUser(this);
        }

    }

    public SearchUser(SearchUser.Builder builder){
        this.username=builder.userName;
    }
}
