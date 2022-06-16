package com.example.buylap.bean;

import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.EmailVerifyException;

public class BeanUser{


    private String type;
    private String username;
    private String email;
    private String password;
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws EmailVerifyException {
        if(email.contains("@")) {
            this.email = email;
        }else{
            throw new EmailVerifyException("Email invalid");
        }
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
