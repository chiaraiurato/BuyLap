package com.example.buylap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.buylap.bean.BeanSeller;
import com.example.buylap.bean.BeanUser;
import com.example.buylap.controller.graphic.RegistrationGraphicController;
import com.example.buylap.exceptions.DAOException;

public class SignupCLIActivity extends AppCompatActivity {
    TextView field;
    ImageView next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signoutcli);
        next = findViewById(R.id.enter);
        field = findViewById(R.id.field);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (field.getText().toString().equals("professional")) {
                    Intent intent = new Intent(SignupCLIActivity.this, SignUpUserCLIActivity.class);
                    startActivity(intent);

                } else if (field.getText().toString().equals("personal")) {
                    Intent intent = new Intent(SignupCLIActivity.this, SignUpSellerCLIActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(SignupCLIActivity.this, "Type professional or personal", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}