package com.example.buylap.Bean;

public class BeanSeller {
    private String businessName;
    private String businessEmail;
    private String password;

    public String getEmail() {
        return businessEmail;
    }

    public void setEmail(String businessEmail) {
        this.businessEmail = businessEmail;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getUsername() {
        return businessName;
    }

    public void setUsername(String businessName) {
        this.businessName = businessName;
    }
}
