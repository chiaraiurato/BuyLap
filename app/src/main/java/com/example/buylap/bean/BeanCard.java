package com.example.buylap.bean;

import com.example.buylap.exceptions.ExpiredDateCardException;
import com.example.buylap.exceptions.LengthBeanCardException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BeanCard {
    private String cardHolderName;
    private String cardNumber;
    private Date expireDate;

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardNumber() throws LengthBeanCardException {
        checkLength();
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getData() {
        return expireDate.toString();
    }

    public void setData(String date) throws ParseException, ExpiredDateCardException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-mm");
        simpleDateFormat.setLenient(false);
        this.expireDate = simpleDateFormat.parse(date);
        boolean expired = expireDate.before(new Date());
        if(expired){
            throw new ExpiredDateCardException("Date is expired");
        }
    }
    private void checkLength() throws LengthBeanCardException {
        if(cardNumber.length() > 20){
            throw new LengthBeanCardException("Number card is invalid");
        }

    }
}
