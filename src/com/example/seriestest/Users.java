package com.example.seriestest;

import java.util.LinkedList;
import java.util.List;

public class Users {
    private List<User> users=new LinkedList<>();

    public List<User> getUsers() {
        return users;
    }

    public void setUser(User user) {
        this.users.add(user);
    }
    public boolean validate(String name,String password)
    {
        for(User each : users)
        {
            if(each.valid(name,password))return true;
        }
        return false;
    }

}
