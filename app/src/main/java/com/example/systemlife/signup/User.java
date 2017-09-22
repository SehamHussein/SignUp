package com.example.systemlife.signup;

import java.io.Serializable;

/**
 * Created by System.Life on 9/22/2017.
 */

public class User implements Serializable {

    String name;
    String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, String password) {

        this.name = name;
        this.password = password;
    }

}
