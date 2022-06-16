package com.example.buylap.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import com.example.buylap.controller.graphic.RegistrationGraphicController;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.R;

public class RegistrationActivity extends AppCompatActivity {

    private RegistrationGraphicController registrationGraphicController;
    private TextView username;
    private TextView email;
    private TextView password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        this.registrationGraphicController = new RegistrationGraphicController(this);

        username = findViewById(R.id.select);
        email = findViewById(R.id.Mail);
        password = findViewById(R.id.Password);
        Button signUp = findViewById(R.id.signup_btn);

        TextView signIn= findViewById(R.id.create_new_one);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrationGraphicController.gotoSignIn();
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(registrationGraphicController.verifyFields()) {
                        registrationGraphicController.registerNewAccountUser();
                    }
                } catch (DAOException | BeanException e) {
                    e.printStackTrace();
                }
            }
        });



    }
    public String sendUsername(){
        return username.getText().toString();
    }
    public String sendEmail(){
        return email.getText().toString();
    }
    public String sendPassword(){
        return password.getText().toString();
    }

}