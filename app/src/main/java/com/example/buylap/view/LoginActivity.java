package com.example.buylap.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.buylap.controller.graphic.LoginGraphicController;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.R;

import java.io.IOException;
import java.sql.SQLException;

public class LoginActivity extends AppCompatActivity {

    private LoginGraphicController loginGraphicController;
    private TextView username;
    private TextView password;
    private RadioButton userRadio;
    private RadioButton sellerRadio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.loginGraphicController = new LoginGraphicController(this);
        userRadio = findViewById(R.id.radio_user_login);
        sellerRadio = findViewById(R.id.radio_seller_login);
        username = findViewById(R.id.select);
        password = findViewById(R.id.Password);
        Button signIn = findViewById(R.id.signIn_btn);

        TextView create = findViewById(R.id.create_new_one);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginGraphicController.goToRegistration();
            }
        });
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type = loginGraphicController.verifyFields(userRadio, sellerRadio);

                try {
                    loginGraphicController.signInUser(type);
                } catch (BeanException throwables) {
                    throwables.printStackTrace();
                } catch (DAOException e) {
                    Toast.makeText(LoginActivity.this, "Sign in failed : wrong credential ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public String sendUsername(){
        return username.getText().toString();
    }
    public String sendPassword(){
        return  password.getText().toString();
    }
}
