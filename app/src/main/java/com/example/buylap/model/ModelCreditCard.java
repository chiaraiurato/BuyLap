package com.example.buylap.model;

public class ModelCreditCard {
    private String name;
    private String number;
    private String data;


    public ModelCreditCard(String name, String number, String data) {
        this.name = name;

        this.number = number;
        this.data = data;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
