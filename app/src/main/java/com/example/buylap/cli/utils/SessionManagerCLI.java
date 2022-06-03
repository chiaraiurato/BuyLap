package com.example.buylap.cli.utils;

import java.util.HashMap;
import java.util.Map;

public class SessionManagerCLI {

    private static  String keyUsername;
    private static String keyPassword;
    private static String keyType;

    public void  createLoginSession(String username, String password, String type){
        keyUsername = username;
        keyPassword = password;
        keyType = type;

    }

    public static Map<String, String> getUserDetails(){
        Map<String, String> user = new HashMap<>();
        user.put("user", keyUsername );
        user.put("password", keyPassword);
        user.put("type", keyType);
        return user;
    }
}
