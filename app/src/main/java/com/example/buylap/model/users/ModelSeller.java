package com.example.buylap.model.users;

public class ModelSeller extends ModelUser{


    private String pIva;

    public ModelSeller(String username, String email, String password, String pIva) {
        super(username, email, password);
        this.pIva = pIva;
    }
    public String getIva() {
        return pIva;
    }

    public void setIva(String pIva) {
        this.pIva = pIva;
    }


}
