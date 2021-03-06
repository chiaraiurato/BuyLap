package com.example.buylap.controller.graphic;

import android.content.Context;
import android.util.Log;

import com.example.buylap.bean.BeanUser;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.utils.SessionManager;

import java.util.Map;
import java.util.Objects;

public class SessionGraphicController {
    protected SessionManager session;
    protected BeanUser beanSession;
    protected Map<String, String> user;

    protected SessionGraphicController(Context context) {
        this.session = new SessionManager(context);
        this.user = session.getUserDetails();
        this.beanSession = new BeanUser();
    }
    protected BeanUser getBeanSession(){
        if(user.get("user") != null) {
            try {
                beanSession.setUsername(Objects.requireNonNull(user.get("user")));
                beanSession.setType(Objects.requireNonNull(user.get("type")));
                beanSession.setPassword(Objects.requireNonNull(user.get("pass")));
            } catch (BeanException e) {
                Log.d("BeanSession", "Field username is null");
            }
        }

        return this.beanSession;
    }
    protected boolean isLogged(){
        return session.isLoggedIn();
    }
}
