package com.example.buylap.Model.Users;

public class Seller extends User{
    public static final String TEST_USERNAME = "tester-seller";

    private String company;

    public Seller(String username, String email) {
        super(username, email);
    }

    public Seller(String username) {
        super(username);
    }


}
