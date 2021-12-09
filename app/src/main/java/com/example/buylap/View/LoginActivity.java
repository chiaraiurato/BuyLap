package com.example.buylap.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.buylap.R;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        TextView username = findViewById(R.id.Username);
        TextView password = findViewById(R.id.Password);
        Button signinbtn = (Button) findViewById(R.id.searchbtn);
        TextView create = findViewById(R.id.create_new_one);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent5);
            }
        });
        signinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                    Toast.makeText(LoginActivity.this, "Sign in success", Toast.LENGTH_SHORT).show();
                    Intent intent4 = new Intent(LoginActivity.this, HomepageActivity.class);
                    startActivity(intent4);
                }else{
                    Toast.makeText(LoginActivity.this, "Sign in error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
