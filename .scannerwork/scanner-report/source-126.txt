package com.example.buylap.cli.utils;

import com.example.buylap.bean.BeanUser;
import com.example.buylap.exceptions.BeanException;

import java.util.HashMap;
import java.util.Map;

public class SessionManagerCLI {

    private SessionManagerCLI(){
        //Singleton
    }
    private static  String keyUsername;
    private static String keyPassword;
    private static String keyType;
    private static BeanUser beanUser;

    public static void  createLoginSession(String username, String password, String type){
        keyUsername = username;
        keyPassword = password;
        keyType = type;
        beanUser = new BeanUser();

    }

    public static BeanUser getUserDetails() throws BeanException {
        Map<String, String> user = new HashMap<>();
        user.put("password", keyPassword);
        user.put("type", keyType);
        user.put("user", keyUsername );
        beanUser.setUsername(user.get("user"));
        beanUser.setType(user.get("type"));
        beanUser.setPassword(user.get("password"));
        return beanUser;
    }
}
