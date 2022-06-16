package com.example.buylap.bean;

import com.example.buylap.exceptions.IvaLengthException;

public class BeanSeller extends BeanUser {

    private String pIva;
    public String getIva() {
        return pIva;
    }

    public void setIva(String pIva) throws IvaLengthException {
        if(pIva.length()>11){
            throw new IvaLengthException("Not a VAT number");
        }
        this.pIva = pIva;
    }

}
