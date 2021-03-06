package com.example.buylap.utils;

import android.content.Context;

import android.content.SharedPreferences;


import com.example.buylap.bean.BeanUser;
import com.example.buylap.controller.applicative.LoginController;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.model.users.ModelUser;

import java.util.HashMap;
import java.util.Map;

public class SessionManager {
    SharedPreferences shar;
    SharedPreferences.Editor editor;

    Context context;
    int privateMode = 0;
    private static final String PREF_NAME = "AndroidPref";
    private static final String IS_LOGIN = "IsLogged";
    public static final String KEY_USERNAME = "user";
    public static final String KEY_MAIL = "mail";
    public static final String KEY_PASSWORD = "pass";
    public static final String KEY_TYPE = "type";


    public SessionManager (Context context){
        this.context = context;
        shar = context.getSharedPreferences(PREF_NAME, privateMode);
        editor = shar.edit();
    }
    public void createLoginSession(String username, String mail, String password, String type){
        editor.putBoolean(IS_LOGIN,true);
        editor.putString(KEY_USERNAME, username);
        editor.putString(KEY_PASSWORD, password);
        editor.putString(KEY_MAIL, mail);
        editor.putString(KEY_TYPE, type);
        editor.commit();
    }

    public boolean isLoggedIn(){
        return shar.getBoolean(IS_LOGIN, false);
    }

    public void logoutUser(){
        editor.clear();
        editor.commit();
    }
    public Map<String, String> getUserDetails(){
        
        Map<String, String> user = new HashMap<>();
        user.put(KEY_USERNAME, shar.getString(KEY_USERNAME, null));
        user.put(KEY_PASSWORD, shar.getString(KEY_PASSWORD, null));
        user.put(KEY_MAIL, shar.getString(KEY_MAIL, null));
        user.put(KEY_TYPE, shar.getString(KEY_TYPE, null));
        return user;
        
    }
}
