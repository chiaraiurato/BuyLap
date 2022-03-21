package com.example.buylap.singleton;

import com.example.buylap.bean.BeanGuest;

public final class GuestSingleton{
    private BeanGuest beanGuest;
    private static final GuestSingleton INSTANCE = new GuestSingleton();

    private GuestSingleton() {}

    public BeanGuest getBeanGuest() {
        return beanGuest;
    }

    public void setBeanGuest(BeanGuest beanGuest) {
        this.beanGuest = beanGuest;
    }

    public static GuestSingleton getINSTANCE() {
        return INSTANCE;
    }
}
