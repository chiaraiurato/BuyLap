package com.example.buylap.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.buylap.R;
import com.example.buylap.controller.graphic.InsertComponentGraphicController;


public class InsertComponentActivity extends AppCompatActivity  {
    private TextView choose;
    private InsertComponentGraphicController insertComponentGraphicController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_component);
        choose = findViewById(R.id.type_item);
        insertComponentGraphicController = new InsertComponentGraphicController(this);
        Button save = findViewById(R.id.save_item);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //bsu
            }
        });
    }

    public void showPopup(View view){
        insertComponentGraphicController.show(view);
    }
    public void setCpu(){
        choose.setText(R.string.Cpu);
    }
    public void setRam() {
        choose.setText(R.string.Ram);
    }
    public void setMotherboard() {
        choose.setText(R.string.Motherboard);
    }
    public void setVideoCard() {
        choose.setText(R.string.Video_card);
    }
    public void setPowerSupply() {
        choose.setText(R.string.Power_supply);
    }
    public void setSsd() {
        choose.setText(R.string.Ssd);
    }
}