package com.example.buylap.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.buylap.R;
import com.example.buylap.controller.applicative.RegistrationController;
import com.example.buylap.controller.graphic.RegistrationGraphicController;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;

public class SelectTypeAccountActivity extends AppCompatActivity {
    private CardView cardViewPersonal;
    private CardView cardViewBusiness;
    private Button next;
    private RegistrationGraphicController registrationGraphicController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_type_account);
        registrationGraphicController = new RegistrationGraphicController(this);
        next = findViewById(R.id.next);
        cardViewPersonal = findViewById(R.id.cardViewPersonal);
        cardViewBusiness = findViewById(R.id.cardViewBusiness);

    }
    public void personalClick (View view){
        resetColor();
        cardViewPersonal.setCardBackgroundColor(getResources().getColor(R.color.green));
        chooseAccount(cardViewPersonal, "personal");
    }
    public void businessClick(View view){
        resetColor();
        cardViewBusiness.setCardBackgroundColor(getResources().getColor(R.color.green));
        chooseAccount(cardViewBusiness, "business");

    }
    private void chooseAccount(CardView cardview, String answer){
        cardview.setCardBackgroundColor(getResources().getColor(R.color.green));

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer.equals("personal")){
                    registrationGraphicController.gotoSignUpUser();
                }else if(answer.equals("business")){
                    registrationGraphicController.gotoSignUpSeller();
                }
            }
        });
    }
    private void resetColor() {
        cardViewPersonal.setCardBackgroundColor(getResources().getColor(R.color.bluebutton));
        cardViewBusiness.setCardBackgroundColor(getResources().getColor(R.color.bluebutton));
    }


}