package com.example.buylap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.buylap.view.BudgetActivity;
import com.example.buylap.view.MainActivity;
import com.example.buylap.view.TakeQuizActivity;

public class GUIActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guiactivity);
        Button buylap = findViewById(R.id.buylap);
        Button buylapCli = findViewById(R.id.buylapcli);

        buylap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(GUIActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        buylapCli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(GUIActivity.this, MainActivityCLI.class);
                startActivity(intent);
            }
        });
    }
}