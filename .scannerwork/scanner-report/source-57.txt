package com.example.buylap.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.buylap.controller.graphic.LoginGraphicController;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.R;

import java.sql.SQLException;

public class LoginActivity extends AppCompatActivity {
    private LoginGraphicController loginGraphicController;
    private TextView username;
    private TextView password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.loginGraphicController = new LoginGraphicController(this);
        username = findViewById(R.id.Username);
        password = findViewById(R.id.Password);
        Button signinbtn = (Button) findViewById(R.id.signup_btn);

        TextView create = findViewById(R.id.create_new_one);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginGraphicController.goToRegistration();
            }
        });
        signinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    loginGraphicController.signIn();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (DAOException e) {
                    e.printStackTrace();
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
