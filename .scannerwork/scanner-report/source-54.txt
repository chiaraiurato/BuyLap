package com.example.buylap;

import com.example.buylap.bean.BeanUser;

public final class UserHolder {

    private BeanUser user;

    private final static UserHolder INSTANCE = new UserHolder();

    private UserHolder() {}

    public static UserHolder getInstance() {
        return INSTANCE;
    }

    public void setUser(BeanUser u) {
        this.user = u;
    }

    public BeanUser getUser() {
        return this.user;
    }
}
