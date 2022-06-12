package com.example.buylap.bean;

import com.example.buylap.cli.graphic_controller.MainGraphicController;

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
        if(!MainGraphicController.CLI){
            this.price = Float.parseFloat(price.substring(0, price.length() - 2));
        }else{
            this.price = Float.parseFloat(price);
        }

    }




}
