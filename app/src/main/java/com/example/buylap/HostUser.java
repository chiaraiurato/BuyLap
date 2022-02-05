package com.example.buylap;

public class HostUser {
    private String guest;
    private static final HostUser INSTANCE = new HostUser();

    private HostUser() {}

    public String getHost() {
        return guest;
    }

    public void setGuest(String guest) {
        this.guest = guest;
    }

    public static HostUser getINSTANCE() {
        return INSTANCE;
    }
}
