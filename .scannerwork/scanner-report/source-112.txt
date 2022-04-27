package com.example.buylap.bean;

import com.example.buylap.exceptions.BeanException;

public class BeanSession {

    private String username;
    private String type;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
