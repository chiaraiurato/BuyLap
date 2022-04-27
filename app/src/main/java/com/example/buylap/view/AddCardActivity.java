package com.example.buylap.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.buylap.R;
import com.example.buylap.controller.graphic.CashbackGraphicController;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;

public class AddCardActivity extends AppCompatActivity {

    private TextView name;
    private EditText numberCard;
    private EditText dateFormat;
    private TextView cvv;
    private int prevCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);
        CashbackGraphicController cashbackGraphicController = new CashbackGraphicController(this);
        name = findViewById(R.id.titles);
        numberCard = findViewById(R.id.subtitles);
        dateFormat = findViewById(R.id.editTextDate);
        cvv = findViewById(R.id.cvv);

        Button saveCard = findViewById(R.id.save_item);

        saveCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cashbackGraphicController.verifyLengthOfCreditCard()) {
                    try {

                        cashbackGraphicController.saveCreditCard();
                    } catch (DAOException | BeanException e) {
                        e.printStackTrace();
                    }
                    openAct();
                }
            }
        });


        numberCard.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //this should be empty
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //this should be empty
            }

            @Override
            public void afterTextChanged(Editable s) {
                String field = s.toString();
                int currCount = field.length();

                if (shouldIncrementOrDecrement(currCount, true)){
                    appendOrStrip(field, true);
                } else if (shouldIncrementOrDecrement(currCount, false)) {
                    appendOrStrip(field, false);
                }
                prevCount = numberCard.getText().toString().length();
            }
        });
    }
    private boolean isAtSpaceDelimiter(int currCount) {
        return currCount == 4 || currCount == 9 || currCount == 14;
    }

    private boolean shouldIncrementOrDecrement(int currCount, boolean shouldIncrement) {
        if (shouldIncrement) {
            return prevCount <= currCount && isAtSpaceDelimiter(currCount);
        } else {
            return prevCount > currCount && isAtSpaceDelimiter(currCount);
        }
    }

    private void appendOrStrip(String field, boolean shouldAppend) {
        StringBuilder sb = new StringBuilder(field);
        if (shouldAppend) {
            sb.append(" ");
        } else {
            sb.setLength(sb.length() - 1);
        }
        numberCard.setText(sb.toString());
        numberCard.setSelection(sb.length());
    }
    private void openAct(){
        Intent intent = new Intent(this, NavigationActivity.class);
        intent.putExtra("gotoCashback", true);
        startActivity(intent);
    }
    public String sendName(){
        return name.getText().toString();
    }
    public String sendNumber(){
        return  numberCard.getText().toString();
    }
    public String sendDate(){
        return dateFormat.getText().toString();
    }
    public String sendCvv(){
        return  cvv.getText().toString();
    }
}