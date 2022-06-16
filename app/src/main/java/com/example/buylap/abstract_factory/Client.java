package com.example.buylap.abstract_factory;

import com.example.buylap.utils.SessionManager;
import com.example.buylap.view.NavigationActivity;

import java.util.Map;

public class Client {
    public NavigationFactory navigationHome;
    public NavigationFactory navigationSetting;
    private Map<String, String> user;
    private SessionManager sessionManager;

    public Client(NavigationActivity navigationActivity) {
        this.sessionManager = new SessionManager(navigationActivity.getApplicationContext());
        this.user = sessionManager.getUserDetails();

        Factory factory = new Factory();
        try{
            this.navigationHome = factory.createNavigationFactory("home", user.get("type") );
            this.navigationSetting = factory.createNavigationFactory("setting", user.get("type") );

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
