package com.restapi.demo.UserProfileListing;

public class UserProfile {
    private String userName;
    public int age;
    private String email;
    private String country;

    public UserProfile(String userName, int age, String email, String country) {
        this.userName = userName;
        this.age = age;
        this.email = email;
        this.country = country;
    }
    public String getUserName() {
        return userName;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getCountry() {
        return country;
    }
}
