package com.example.buylap.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.buylap.R;
import com.example.buylap.controller.graphic.CashbackGraphicController;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;

import java.util.Calendar;

public class AddCardActivity extends AppCompatActivity {

    private TextView name;
    private TextView numberCard;
    private EditText dateFormat;
    private TextView cvv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);
        CashbackGraphicController cashbackGraphicController = new CashbackGraphicController(this);
        name = findViewById(R.id.name_card);
        numberCard = findViewById(R.id.number_card);
        dateFormat = findViewById(R.id.editTextDate);
        cvv = findViewById(R.id.cvv);

        Button saveCard = findViewById(R.id.save_card);

        saveCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    cashbackGraphicController.saveCreditCard();
                } catch (DAOException | BeanException e) {
                    e.printStackTrace();
                }
                openAct();
            }
        });

    }
    private void openAct(){
        Intent intent = new Intent(this, NavigationActivity.class);
        intent.putExtra("gotoCashback", true);
        startActivity(intent);
    }
    public String sendName(){
        return name.getText().toString();
    }
    public String sendNumber(){
        return  numberCard.getText().toString();
    }
    public String sendDate(){
        return dateFormat.getText().toString();
    }
    public String sendCvv(){
        return  cvv.getText().toString();
    }
}