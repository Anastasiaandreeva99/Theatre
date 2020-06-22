package com.example.seriestest;

public class User {
    private String name;
    private String password;

    private String getName() {
        return name;
    }

    private String getPassword() {
        return password;
    }
    public boolean valid(String name,String password)
    {
        return(this.name.equals(name) && this.password.equals(password));
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
