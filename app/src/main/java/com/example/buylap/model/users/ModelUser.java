package com.example.buylap.model.users;

import com.example.buylap.model.ModelCreditCard;
import com.example.buylap.model.ModelPoints;

public class ModelUser{

    private String username;
    private String email;
    private String password;
    private ModelCreditCard creditCard;
    private ModelPoints modelPoints;

    public ModelUser(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.creditCard = new ModelCreditCard("","0000 0000 0000 0000", "00-00" );
        this.modelPoints = new ModelPoints(0);
    }

    public ModelUser(String username, String email, String password, ModelCreditCard creditCard) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.creditCard = creditCard;
    }
    public ModelUser(String username, String email, String password, ModelCreditCard creditCard, ModelPoints modelPoints) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.creditCard = creditCard;
        this.modelPoints = modelPoints;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public ModelPoints getModelPoints() {
        return modelPoints;
    }

    public void setModelPoints(ModelPoints modelPoints) {
        this.modelPoints = modelPoints;
    }
}