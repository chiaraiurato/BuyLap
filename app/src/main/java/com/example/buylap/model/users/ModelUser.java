package com.example.buylap.model.users;

import com.example.buylap.model.ModelCashback;
import com.example.buylap.model.ModelCreditCard;

public class ModelUser{

    private String type;
    private String username;
    private String email;
    private String password;
    private ModelCreditCard creditCard;
    private ModelCashback modelCashback;

    public ModelUser(String type, String username, String email, String password) {
        this.type = type;
        this.username = username;
        this.email = email;
        this.password = password;
        this.creditCard = new ModelCreditCard("","0000 0000 0000 0000", "00-00" );
        this.modelCashback = new ModelCashback(0);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ModelCreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(ModelCreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public ModelCashback getModelCashback() {
        return modelCashback;
    }

    public void setModelCashback(ModelCashback modelCashback) {
        this.modelCashback = modelCashback;
    }
}