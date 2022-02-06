package com.example.buylap.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.buylap.R;
import com.example.buylap.controller.graphic.MainGraphicController;

public class MainActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button movesignup;
        Button movesignin;
        TextView moveskip;
        setContentView(R.layout.activity_main);

        MainGraphicController mainGraphicController = new MainGraphicController(this);
        movesignup=findViewById(R.id.signup_btn);
        movesignin=findViewById(R.id.Move_signin);
        moveskip=findViewById(R.id.skip);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)


        movesignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(intent);

            }
        });
        movesignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent2);
            }
        });
        moveskip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mainGraphicController.setHost();
            }
        });


    }

}