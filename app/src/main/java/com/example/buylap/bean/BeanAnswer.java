package com.example.buylap.bean;

import com.example.buylap.cli.graphic_controller.MainGraphicController;

public class BeanAnswer {

    private String answer1;
    private String answer2;
    private String answer3;
    private float priceSelected;

    public float getPriceSelected() {
        return priceSelected;
    }

    public void setPriceSelected(String priceSelected) {
        if(!MainGraphicController.CLI){
            this.priceSelected = Float.parseFloat(priceSelected.substring(0, priceSelected.length() - 2));
        }else{
            this.priceSelected = Float.parseFloat(priceSelected);
        }
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }
}
