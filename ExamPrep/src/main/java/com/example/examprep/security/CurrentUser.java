package com.example.examprep.security;

public class CurrentUser {
    private static final String ANONYMOUS = "anonymous";
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
