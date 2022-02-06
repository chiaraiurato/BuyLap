package com.example.buylap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.buylap.controller.graphic.RegistrationGraphicController;

public class SignUpSellerCLIActivity extends AppCompatActivity {
    RegistrationGraphicController registrationGraphicController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2_cliactivity);
        registrationGraphicController = new RegistrationGraphicController(this);
        TextView field;
        field = findViewById(R.id.field);
        ImageView next = findViewById(R.id.enter);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrationGraphicController.setSellerCLI(field.getText().toString());
            }
        });


    }
}