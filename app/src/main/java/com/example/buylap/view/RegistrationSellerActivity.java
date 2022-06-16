package com.example.buylap.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.buylap.R;
import com.example.buylap.controller.graphic.RegistrationGraphicController;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;

public class RegistrationSellerActivity extends AppCompatActivity {
    private RegistrationGraphicController registrationGraphicController;
    private TextView username;
    private TextView email;
    private TextView password;
    private TextView iva;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_seller);
        this.registrationGraphicController = new RegistrationGraphicController(this);

        username = findViewById(R.id.username_seller);
        email = findViewById(R.id.MailSeller);
        password = findViewById(R.id.PasswordSeller);
        iva = findViewById(R.id.iva);
        Button signUp = findViewById(R.id.signup_btn_seller);

        TextView signIn= findViewById(R.id.create_new_one_seller);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrationGraphicController.gotoSignInSeller();
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(registrationGraphicController.verifyFieldsSeller()) {
                        registrationGraphicController.registerNewAccountSeller();
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
    public String sendIva(){
        return iva.getText().toString();
    }
}