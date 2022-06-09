package com.example.buylap.controller.graphic;

import android.content.Context;
import android.util.Log;

import com.example.buylap.bean.BeanSession;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.utils.SessionManager;

import java.util.Map;
import java.util.Objects;

public class SessionGraphicController {
    protected SessionManager session;
    protected BeanSession beanSession;
    protected Map<String, String> user;

    protected SessionGraphicController(Context context) {
        this.session = new SessionManager(context);
        this.user = session.getUserDetails();
        this.beanSession = new BeanSession();
        if(user.get("user") != null) {
            try {
                beanSession.setUsername(Objects.requireNonNull(user.get("user")));
            } catch (BeanException e) {
                Log.d("BeanSession", "Field username is null");
            }
        }
        Log.d("user ", " "+session.isLoggedIn());
        beanSession.setType(user.get("type"));
    }
    public BeanSession getBeanSession(){
        return this.beanSession;
    }
    public boolean isLogged(){
        return session.isLoggedIn();
    }
}
