package com.example.buylap.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.buylap.R;
import com.example.buylap.controller.graphic.CashbackGraphicController;
import com.example.buylap.exceptions.DAOException;

public class AddCardActivity extends AppCompatActivity {

    private TextView name;
    private TextView numberCard;
    private EditText date;
    private TextView cvv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);
        CashbackGraphicController cashbackGraphicController = new CashbackGraphicController(this);
        name = findViewById(R.id.name_card);
        numberCard = findViewById(R.id.number_card);
        date = findViewById(R.id.editTextDate);
        cvv = findViewById(R.id.cvv);

        Button saveCard = findViewById(R.id.save_card);

        saveCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    cashbackGraphicController.saveCreditCard();
                } catch (DAOException e) {
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
        return date.getText().toString();
    }
    public String sendCvv(){
        return  cvv.getText().toString();
    }
}