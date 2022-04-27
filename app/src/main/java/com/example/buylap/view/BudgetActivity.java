package com.example.buylap.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.example.buylap.R;
import com.example.buylap.controller.graphic.QuizResultGraphicController;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;


public class BudgetActivity extends AppCompatActivity {

    private TextView budget;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);
        QuizResultGraphicController quizResultGraphicController = new QuizResultGraphicController(this);
        SeekBar mySeekbar = findViewById(R.id.seekBar);
        budget = findViewById(R.id.budget);
        TextView next = findViewById(R.id.next_btn);
        mySeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String price = progress + " $" ;
                budget.setText(price);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //this should be empty
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //this should be empty
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                quizResultGraphicController.setPrice();
                Intent intent = new Intent(BudgetActivity.this, TakeQuizActivity.class);
                startActivity(intent);
            }
        });
    }
    public String sendPrice(){
        return budget.getText().toString();
    }

}