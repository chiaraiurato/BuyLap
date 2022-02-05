package com.example.buylap.model.Users;

public class ModelSeller extends ModelUser{
    public static final String TEST_USERNAME = "tester-seller";

    private String company;


    public ModelSeller(String username, String email, String password) {
        super(username, email, password);
    }
}
