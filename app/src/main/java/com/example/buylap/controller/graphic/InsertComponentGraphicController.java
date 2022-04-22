package com.example.buylap.controller.graphic;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import com.example.buylap.R;
import com.example.buylap.utils.SessionManager;
import com.example.buylap.view.InsertComponentActivity;

public class InsertComponentGraphicController implements PopupMenu.OnMenuItemClickListener{
    InsertComponentActivity insertComponentActivity;
    SessionManager sessionManager;

    public InsertComponentGraphicController(InsertComponentActivity insertComponentActivity) {
        this.insertComponentActivity = insertComponentActivity;
        this.sessionManager = new SessionManager(insertComponentActivity.getApplicationContext());
    }
    public void show(View view){
        Context wrapper = new ContextThemeWrapper(insertComponentActivity, R.style.Buylap_PopupMenu);
        PopupMenu popupMenu = new PopupMenu(wrapper, view);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.menu_item);
        popupMenu.show();

    }
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_cpu:
                insertComponentActivity.setCpu();
                return true;
            case R.id.nav_ram:
                insertComponentActivity.setRam();
                return true;
            case R.id.nav_motherboard:
                insertComponentActivity.setMotherboard();
                return true;
            case R.id.nav_videocard:
                insertComponentActivity.setVideoCard();
                return true;
            case R.id.nav_powersupply:
                insertComponentActivity.setPowerSupply();
                return true;
            case R.id.nav_ssd:
                insertComponentActivity.setSsd();
                return true;
            default:
                return false;
        }
    }

}
