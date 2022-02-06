package com.example.buylap.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.example.buylap.R;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;


public class BudgetActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);
        SeekBar mySeekbar = findViewById(R.id.seekBar);
        TextView budget = findViewById(R.id.budget);
        TextView next = findViewById(R.id.next_btn);
        mySeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                budget.setText(String.valueOf(progress) + " $");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BudgetActivity.this, TakeQuizActivity.class);
                startActivity(intent);
            }
        });
    }
}