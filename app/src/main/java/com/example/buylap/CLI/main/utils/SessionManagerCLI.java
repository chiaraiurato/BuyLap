package com.example.buylap.CLI.main.utils;

import java.util.HashMap;
import java.util.Map;

public class SessionManagerCLI {

    public static  String KEY_USERNAME;
    public static String KEY_PASSWORD;
    public static String KEY_TYPE;

    public void  createLoginSession(String username, String password, String type){
        KEY_USERNAME = username;
        KEY_PASSWORD = password;
        KEY_TYPE = type;

    }

    public void logoutUser(){
        KEY_USERNAME = "";
        KEY_PASSWORD = "";
        KEY_TYPE = "";
    }
    public Map<String, String> getUserDetails(){
        Map<String, String> user = new HashMap<>();
        user.put("user", KEY_USERNAME );
        user.put("password", KEY_PASSWORD);
        user.put("type", KEY_TYPE);
        return user;
    }
}
