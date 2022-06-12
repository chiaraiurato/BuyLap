package com.example.buylap.bean;

public class BeanRequestBuild {

    private BeanAnswer keyword;
    private float price;

    public BeanAnswer getKeyword() {
        return keyword;
    }

    public void setKeyword(BeanAnswer keyword) {
        this.keyword = keyword;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(String price) {
        float floatPrice = Float.parseFloat(price.substring(0, price.length() - 2));
        this.price = floatPrice;
    }




}
