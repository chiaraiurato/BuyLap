package com.example.buylap.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.buylap.R;
import com.example.buylap.bean.BeanCard;
import com.example.buylap.controller.graphic.CashbackGraphicController;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;

import java.io.FileNotFoundException;
import java.sql.SQLException;


public class CashbackFragment extends Fragment {

    private CashbackGraphicController cashbackGraphicController;
    private TextView numberCard;
    private TextView dateCard;
    private TextView cardHolderName;
    private TextView pointsEarned;
    private Button cashout;
    public CashbackFragment() {
        // Required empty public constructor
    }
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
        cashout = view.findViewById(R.id.cashout_btn);

        this.cashbackGraphicController = new CashbackGraphicController(this);
        try {
            cashbackGraphicController.uploadCreditCardAndPoints();
        } catch (DAOException ignored) {

        } catch (BeanException | SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }
        addCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AddCardActivity.class);
                startActivity(intent);
            }
        });
        cashout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    cashbackGraphicController.cashOutPoints();
                } catch (BeanException | SQLException | FileNotFoundException e) {
                    e.printStackTrace();
                } catch (DAOException e) {
                    //ignored
                }
            }
        });
        deleteCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    cashbackGraphicController.deleteCreditCard();
                } catch (BeanException | DAOException e) {
                    //risovere exception bean
                    e.printStackTrace();
                }
            }
        });
        return view;

    }
    public void setCreditCard(BeanCard beanCard){
        String numberCardBean = beanCard.getCardNumber();
        String formatNumberCard = "**** **** **** "+ numberCardBean.substring(numberCardBean.length()-4);
        numberCard.setText(formatNumberCard);
        dateCard.setText(beanCard.getData());
        cardHolderName.setText(beanCard.getCardHolderName());
    }

    @SuppressLint("SetTextI18n")
    public void deleteCreditCard() {
        numberCard.setText("**** **** **** 0000");
        dateCard.setText("00-00");
        cardHolderName.setText("");
    }

    public void setPoints(int points) {
        pointsEarned.setText(String.valueOf(points));
    }
    public void cashOutPoints(){
        pointsEarned.setText("0");
    }
}