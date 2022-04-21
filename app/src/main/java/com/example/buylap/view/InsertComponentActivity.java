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


public class InsertComponentActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    private TextView choose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_component);
        choose = findViewById(R.id.type_item);

        Button save = findViewById(R.id.save_item);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //bsu
            }
        });
    }
  public void showPopup(View view){
      Context wrapper = new ContextThemeWrapper(this, R.style.Buylap_PopupMenu);
      PopupMenu popupMenu = new PopupMenu(wrapper, view);
      popupMenu.setOnMenuItemClickListener(this);
      popupMenu.inflate(R.menu.menu_item);
      popupMenu.show();

  }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_cpu:
                choose.setText(R.string.Cpu);
                return true;
            case R.id.nav_ram:
                choose.setText(R.string.Ram);
                return true;
            case R.id.nav_motherboard:
                choose.setText(R.string.Motherboard);
                return true;
            case R.id.nav_videocard:
                choose.setText(R.string.Video_card);
                return true;
            case R.id.nav_powersupply:
                choose.setText(R.string.Power_supply);
                return true;
            case R.id.nav_ssd:
                choose.setText(R.string.Ssd);
                return true;
            default:
                return false;
        }
    }
}