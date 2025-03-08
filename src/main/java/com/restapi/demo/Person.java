package com.restapi.demo;

import java.util.List;

public class Person {
    private String name;
    private int age;
    private String email;
    private boolean isStudent;
    private List<String> courses;


    public Person(String name, int age, String email, boolean isStudent, List<String> courses) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.isStudent = isStudent;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }
}
