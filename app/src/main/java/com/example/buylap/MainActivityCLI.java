package com.example.buylap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.buylap.controller.graphic.MainGraphicController;

public class MainActivityCLI extends AppCompatActivity {
    TextView input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cli);
        ImageView enter = findViewById(R.id.enter);
        input = findViewById(R.id.select);
        MainGraphicController mainGraphicController = new MainGraphicController(this);



        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainGraphicController.getNumber(input.getText().toString());
            }
        });
    }

}