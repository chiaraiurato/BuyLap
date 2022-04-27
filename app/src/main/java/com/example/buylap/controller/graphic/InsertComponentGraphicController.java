package com.example.buylap.controller.graphic;

import android.content.Context;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import com.example.buylap.ConstantNameTable;
import com.example.buylap.R;
import com.example.buylap.bean.BeanBuild;
import com.example.buylap.bean.BeanSession;
import com.example.buylap.controller.applicative.InsertComponentController;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.utils.SessionManager;
import com.example.buylap.view.InsertComponentActivity;

import java.util.Map;

public class InsertComponentGraphicController implements PopupMenu.OnMenuItemClickListener{
    private InsertComponentActivity insertComponentActivity;
    private SessionManager sessionManager;
    private InsertComponentController insertComponentController;
    private BeanBuild beanBuild = new BeanBuild();

    public InsertComponentGraphicController(InsertComponentActivity insertComponentActivity) {
        this.insertComponentActivity = insertComponentActivity;
        this.insertComponentController = new InsertComponentController();
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
                beanBuild.setType(ConstantNameTable.CPU);
                return true;
            case R.id.nav_ram:
                insertComponentActivity.setRam();
                beanBuild.setType(ConstantNameTable.RAM);
                return true;
            case R.id.nav_motherboard:
                insertComponentActivity.setMotherboard();
                beanBuild.setType(ConstantNameTable.MOTHERBOARD);
                return true;
            case R.id.nav_videocard:
                insertComponentActivity.setVideoCard();
                beanBuild.setType(ConstantNameTable.VIDEO_CARD);
                return true;
            case R.id.nav_powersupply:
                insertComponentActivity.setPowerSupply();
                beanBuild.setType(ConstantNameTable.POWER_SUPPLY);
                return true;
            case R.id.nav_ssd:
                insertComponentActivity.setSsd();
                beanBuild.setType(ConstantNameTable.SSD);
                return true;
            default:
                return false;
        }
    }

    public void saveComponent() throws BeanException, DAOException {
        BeanSession beanSession = new BeanSession();
        Map<String, String> user = sessionManager.getUserDetails();
        if(user.get("user") != null) {
            beanSession.setUsername(user.get("user"));
        }
        Log.d("DV", "component type "+ beanBuild.getType());
        beanBuild.setTitle(insertComponentActivity.sendTitle());
        beanBuild.setSubtitles(insertComponentActivity.sendSubtitles());
        beanBuild.setPrice(insertComponentActivity.sendPrice());
        beanBuild.setUrlEbay(insertComponentActivity.sendUrl());
       Boolean result=  insertComponentController.saveComponent(beanBuild, beanSession);
        if (Boolean.TRUE.equals(result)) {
            Log.d("DATABASE", "Component saved");
        }

    }
}
