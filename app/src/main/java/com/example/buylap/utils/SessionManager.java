package com.example.buylap.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.buylap.view.MainActivity;
import com.example.buylap.view.NavigationActivity;

import java.util.HashMap;

public class SessionManager {
    SharedPreferences shar;
    SharedPreferences.Editor editor;

    Context context;
    int Private_mode = 0;
    private static final String PREF_NAME = "AndroidPref";
    private static final String IS_LOGIN = "IsLogged";
    public static final String KEY_USERNAME = "user";
    public static final String KEY_PASSWORD = "pass";
    public static final String KEY_TYPE = "type";

    public SessionManager (Context context){
        this.context = context;
        shar = context.getSharedPreferences(PREF_NAME, Private_mode);
        editor = shar.edit();
    }
    public void  createLoginSession(String username, String password, String type){
        editor.putBoolean(IS_LOGIN,true);
        editor.putString(KEY_USERNAME, username);
        editor.putString(KEY_PASSWORD, password);
        editor.putString(KEY_TYPE, type);

        editor.commit();
    }
    public boolean isLoggedIn(){
        return shar.getBoolean(IS_LOGIN, false);
    }

    public void logoutUser(){
        editor.clear();
        editor.commit();
        /*
        Intent intent = new Intent(context, MainActivity.class);


        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);


        context.startActivity(intent);

         */
    }
    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<>();
        user.put(KEY_USERNAME, shar.getString(KEY_USERNAME, null));
        user.put(KEY_PASSWORD, shar.getString(KEY_PASSWORD, null));
        user.put(KEY_TYPE, shar.getString(KEY_TYPE, null));
        return user;
    }
}
