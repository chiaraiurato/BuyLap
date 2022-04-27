package com.example.buylap.bean;

import com.example.buylap.exceptions.BeanException;

public class BeanUser {
    private String username;
    private String email;
    private String password;
    private int points;

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws BeanException {
        if (password.isEmpty())
            throw new BeanException("Password is empty");
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) throws BeanException {
        if (username.isEmpty())
            throw new BeanException("Username is empty");
        else
            this.username = username;
    }
}
