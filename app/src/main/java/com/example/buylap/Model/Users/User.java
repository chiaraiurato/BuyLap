package com.example.buylap.Model.Users;

public abstract class User{

    protected String username;
    protected String email;


    protected User (String username, String email) {
        this.username = username;
        this.email = email;
    }

    protected User (String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }


}