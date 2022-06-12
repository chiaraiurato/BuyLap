package com.example.buylap.cli.utils;

import com.example.buylap.bean.BeanSession;
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
    private static BeanSession beanSession;

    public static void  createLoginSession(String username, String password, String type){
        keyUsername = username;
        keyPassword = password;
        keyType = type;
        beanSession = new BeanSession();

    }

    public static BeanSession getUserDetails() throws BeanException {
        Map<String, String> user = new HashMap<>();
        user.put("password", keyPassword);
        user.put("type", keyType);
        user.put("user", keyUsername );
        beanSession.setType(user.get("type"));
        beanSession.setUsername(user.get("user"));
        return beanSession;
    }
}
