package com.example.buylap.singleton;

import com.example.buylap.bean.BeanUser;

public final class UserSingleton {

    private BeanUser user;

    private static final UserSingleton INSTANCE = new UserSingleton();

    private UserSingleton() {}

    public static UserSingleton getInstance() {
        return INSTANCE;
    }

    public void setUser(BeanUser u) {
        this.user = u;
    }

    public BeanUser getUser() {
        return this.user;
    }
}
