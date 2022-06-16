package com.example.buylap.controller.graphic;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import com.example.buylap.bean.BeanComponentFromEbay;
import com.example.buylap.bean.BeanSeller;
import com.example.buylap.utils.ConstantNameTable;
import com.example.buylap.R;
import com.example.buylap.controller.applicative.InsertComponentController;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.view.InsertComponentActivity;
import com.example.buylap.view.NavigationActivity;

public class InsertComponentGraphicController extends SessionGraphicController implements PopupMenu.OnMenuItemClickListener{
    private InsertComponentActivity insertComponentActivity;
    private InsertComponentController insertComponentController;
    private BeanComponentFromEbay beanComponentFromEbay;


    public InsertComponentGraphicController(InsertComponentActivity insertComponentActivity) {
        super(insertComponentActivity.getApplicationContext());
        this.insertComponentActivity = insertComponentActivity;
        this.insertComponentController = new InsertComponentController();
        this.beanComponentFromEbay =new BeanComponentFromEbay();
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
                beanComponentFromEbay.setType(ConstantNameTable.CPU);
                return true;
            case R.id.nav_ram:
                insertComponentActivity.setRam();
                beanComponentFromEbay.setType(ConstantNameTable.RAM);
                return true;
            case R.id.nav_motherboard:
                insertComponentActivity.setMotherboard();
                beanComponentFromEbay.setType(ConstantNameTable.MOTHERBOARD);
                return true;
            case R.id.nav_videocard:
                insertComponentActivity.setVideoCard();
                beanComponentFromEbay.setType(ConstantNameTable.VIDEO_CARD);
                return true;
            case R.id.nav_powersupply:
                insertComponentActivity.setPowerSupply();
                beanComponentFromEbay.setType(ConstantNameTable.POWER_SUPPLY);
                return true;
            case R.id.nav_ssd:
                insertComponentActivity.setSsd();
                beanComponentFromEbay.setType(ConstantNameTable.SSD);
                return true;
            default:
                return false;
        }
    }

    public void saveComponent() throws BeanException, DAOException {

        beanComponentFromEbay.setTitle(insertComponentActivity.sendTitle());
        beanComponentFromEbay.setSubtitles(insertComponentActivity.sendSubtitles());
        beanComponentFromEbay.setPrice(insertComponentActivity.sendPrice());
        beanComponentFromEbay.setUrlEbay(insertComponentActivity.sendUrl());
        BeanSeller beanSeller = new BeanSeller();
        //VEDERE
        Boolean result=  insertComponentController.saveComponent(beanComponentFromEbay, beanSeller);
        if (Boolean.TRUE.equals(result)) {
            Log.d("DATABASE", "Component saved");
        }
        Intent intent = new Intent(insertComponentActivity, NavigationActivity.class);
        insertComponentActivity.startActivity(intent);
    }
}
