package com.example.buylap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button movesignup;
        Button movesignin;
        TextView moveskip;
        setContentView(R.layout.activity_main);

        movesignup=findViewById(R.id.searchbtn);
        movesignin=findViewById(R.id.Move_signin);
        moveskip=findViewById(R.id.skip);



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
                Intent intent3 = new Intent(MainActivity.this, HomepageActivity.class);
                startActivity(intent3);
            }
        });


    }

}