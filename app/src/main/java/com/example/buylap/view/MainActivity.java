package com.example.buylap.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.buylap.R;
import com.example.buylap.controller.graphic.MainGraphicController;

public class MainActivity extends AppCompatActivity{

    protected static Context appContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button moveSignUp;
        Button moveSignIn;
        TextView moveSkip;
        setContentView(R.layout.activity_main);

        this.appContext =getApplicationContext();
        MainGraphicController mainGraphicController = new MainGraphicController(this);
        moveSignUp=findViewById(R.id.signup_btn);
        moveSignIn=findViewById(R.id.signin_btn);
        moveSkip=findViewById(R.id.skip);

        moveSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(intent);

            }
        });
        moveSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent2);
            }
        });
        moveSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mainGraphicController.setHost();
            }
        });


    }
    public static Context getContext(){ return appContext ;}

}