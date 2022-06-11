package com.example.buylap.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.buylap.R;
import com.example.buylap.bean.BeanCard;
import com.example.buylap.bean.BeanPoints;
import com.example.buylap.controller.graphic.CashbackGraphicController;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.exceptions.ExpiredDateCardException;
import com.example.buylap.exceptions.LengthBeanCardException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;


public class CashbackFragment extends Fragment {

    private CashbackGraphicController cashbackGraphicController;
    private TextView numberCard;
    private TextView dateCard;
    private TextView cardHolderName;
    private TextView pointsEarned;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cashback, container, false);
        ImageView addCart = view.findViewById(R.id.add_cart_btn);
        ImageView deleteCart = view.findViewById(R.id.delete_card_btn);
        numberCard = view.findViewById(R.id.numberCard);
        dateCard = view.findViewById(R.id.date_card);
        cardHolderName = view.findViewById(R.id.card_holder_name);
        pointsEarned = view.findViewById(R.id.points_earned);
        Button cashout = view.findViewById(R.id.cashout_btn);

        try {
            this.cashbackGraphicController = new CashbackGraphicController(this);
        } catch (BeanException e) {
            e.printStackTrace();
        }
        try {
            cashbackGraphicController.uploadCreditCard();
        } catch (DAOException e) {
            Log.d("DAOcard", "empty card");
            deleteCreditCard();
        } catch (ExpiredDateCardException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            Log.d("ParseException", "format date incorrect");
        }
        try {
            cashbackGraphicController.uploadPoints();

        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        addCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cashbackGraphicController.gotoAddCardActivity();
            }
        });
        cashout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    cashbackGraphicController.cashOutPoints();
                } catch (SQLException | IOException e) {
                    e.printStackTrace();}
            }
        });
        deleteCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    cashbackGraphicController.deleteCreditCard();
                } catch (DAOException e) {
                    //resolve exception bean
                    e.printStackTrace();
                }
            }
        });
        return view;

    }
    public void setCreditCard(BeanCard beanCard) {
        if(beanCard == null){
            deleteCreditCard();
        }else{
            String numberCardBean = beanCard.getCardNumber();
            String formatNumberCard = "**** **** **** "+ numberCardBean.substring(numberCardBean.length()-4);
            numberCard.setText(formatNumberCard);
            dateCard.setText(beanCard.getData());
            cardHolderName.setText(beanCard.getCardHolderName());
        }

    }
    @SuppressLint("SetTextI18n")
    public void deleteCreditCard() {
        numberCard.setText("**** **** **** 0000");
        dateCard.setText("00-00");
        cardHolderName.setText("");
    }

    public void setPoints(BeanPoints beanPoints){
        String points = String.valueOf(beanPoints.getPoints());
        pointsEarned.setText(points);
    }
}