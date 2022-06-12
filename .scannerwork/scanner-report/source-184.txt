package com.example.buylap.model.users;

public class ModelSeller extends ModelUser{


    private String p_iva;

    public ModelSeller(String username, String email, String password, String p_iva) {
        super(username, email, password);
        this.p_iva=p_iva;
    }
    public String getP_iva() {
        return p_iva;
    }

    public void setP_iva(String p_iva) {
        this.p_iva = p_iva;
    }


}
