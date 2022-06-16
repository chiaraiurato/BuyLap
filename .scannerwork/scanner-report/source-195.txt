package com.example.buylap.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.buylap.R;
import com.example.buylap.controller.graphic.InsertComponentGraphicController;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;


public class InsertComponentActivity extends AppCompatActivity  {
    private TextView choose;
    private EditText urlEbay;
    private EditText titles;
    private EditText subtitles;
    private EditText price;
    private InsertComponentGraphicController insertComponentGraphicController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_component);
        choose = findViewById(R.id.type_item);
        urlEbay = findViewById(R.id.url_ebay);
        titles = findViewById(R.id.titles);
        subtitles = findViewById(R.id.subtitles);
        price = findViewById(R.id.price_item);
        insertComponentGraphicController = new InsertComponentGraphicController(this);
        Button save = findViewById(R.id.save_item);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    insertComponentGraphicController.saveComponent();
                } catch (BeanException | DAOException e) {
                    e.printStackTrace();
                }
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
    public String sendType(){
       return choose.getText().toString();
    }
    public String sendTitle(){
        return titles.getText().toString();
    }
    public String sendUrl(){
        return urlEbay.getText().toString();
    }

    public String sendSubtitles() {
        return subtitles.getText().toString();
    }

    public float sendPrice() {
        return Float.parseFloat(price.getText().toString());
    }
}