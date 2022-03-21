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
        RadioButton userRadio = findViewById(R.id.radio_user);
        RadioButton sellerRadio = findViewById(R.id.radio_seller);

        username = findViewById(R.id.select);
        email = findViewById(R.id.Mail);
        password = findViewById(R.id.Password);
        Button signUp = findViewById(R.id.signup_btn);

        TextView signIn= findViewById(R.id.create_new_one);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type = registrationGraphicController.selectTypeAccount(username.getText().toString(), email.getText().toString(), password.getText().toString(), userRadio, sellerRadio);
                switch (type){
                    case "USER":
                        try {
                            registrationGraphicController.registerNewAccountUser();
                            Intent intent = new Intent(RegistrationActivity.this, NavigationActivity.class);
                            startActivity(intent);
                        } catch (DAOException | BeanException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "SELLER":
                        try {
                            registrationGraphicController.registerNewAccountSeller();
                            Intent intent = new Intent(RegistrationActivity.this, NavigationActivity.class);
                            startActivity(intent);
                        } catch (DAOException e) {
                            e.printStackTrace();
                        }
                        break;
                    default:
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