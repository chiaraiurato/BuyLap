package com.example.buylap.bean;

import android.util.Log;

import com.example.buylap.exceptions.ExpiredDateCardException;
import com.example.buylap.exceptions.LengthBeanCardException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BeanCard {
    private String cardHolderName;
    private String cardNumber;
    private String expireDate;

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardNumber(){

        return cardNumber;
    }

    public void setCardNumber(String cardNumber)  {
        try {
            checkLength();
        } catch (LengthBeanCardException e) {
            e.printStackTrace();
        }
        this.cardNumber = cardNumber;
    }

    public String getData() {
        return expireDate;
    }

    public void setData(String date) throws ParseException, ExpiredDateCardException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-mm");
        simpleDateFormat.setLenient(false);
        Date expireDateFormat =simpleDateFormat.parse(date);

        boolean expired = expireDateFormat.before(new Date());
        if(expired){
            throw new ExpiredDateCardException("Date is expired");
        }else{
            this.expireDate= date;
        }
    }
    private void checkLength() throws LengthBeanCardException {
        if(cardNumber != null && cardNumber.length() > 20) {
                throw new LengthBeanCardException("Number card is invalid");
            }
        }

}

