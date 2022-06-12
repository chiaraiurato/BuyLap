package com.example.buylap.utils;

import android.content.Context;



public class ContextHolder {
    private static ContextHolder instance;
    private Context context;

    protected ContextHolder() {
        //Singleton
    }
    public static ContextHolder getInstance(){
        if (instance == null) {
            instance = new ContextHolder();
        }
        return instance;
    }
    public Context getContext(){
        return context;
    }
    public void setContext(Context context){
        this.context = context;
    }
}
