package com.example.buylap.controller.graphic;

import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import com.example.buylap.HostUser;
import com.example.buylap.MainActivityCLI;
import com.example.buylap.SignupCLIActivity;
import com.example.buylap.view.MainActivity;
import com.example.buylap.view.NavigationActivity;

public class MainGraphicController {
    MainActivity mainActivity;
    MainActivityCLI mainActivityCLI;

    public MainGraphicController(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }

    public MainGraphicController(MainActivityCLI mainActivityCLI){
        this.mainActivityCLI = mainActivityCLI;
    }
    public void setHost(){
        Intent intent = new Intent(mainActivity, NavigationActivity.class);
        HostUser hostUser = HostUser.getINSTANCE();
        hostUser.setGuest("guest");
        mainActivity.startActivity(intent);
    }

    public void getNumber(String number) {
        Intent intent;
        switch (number) {
            case "1":
                intent = new Intent(mainActivityCLI, SignupCLIActivity.class);
                mainActivityCLI.startActivity(intent);
                break;
/*
            case '2':
                intent =

                break;
            case '3':
                intent =
                break;

 */
            default:
                Toast.makeText(mainActivityCLI, "Required a number", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
