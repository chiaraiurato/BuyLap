package com.example.buylap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.buylap.controller.applicative.RegistrationController;
import com.example.buylap.controller.graphic.RegistrationGraphicController;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;

public class SelectTypeAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_type_account);
        Button next;
        RegistrationGraphicController registrationGraphicController = new RegistrationGraphicController(this);
        next = findViewById(R.id.next);
        RadioButton userRadio = findViewById(R.id.radio_user);
        RadioButton sellerRadio = findViewById(R.id.radio_seller);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type = registrationGraphicController.selectTypeAccount(userRadio, sellerRadio);
                switch (type){
                    case "USER":
                        registrationGraphicController.gotoSignUpUser();
                        break;
                    case "SELLER":
                        registrationGraphicController.gotoSignUpSeller();
                        break;
                    default:
                }
            }
        });

    }

}