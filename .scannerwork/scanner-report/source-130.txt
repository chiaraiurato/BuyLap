package com.example.buylap.cli.view;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.buylap.cli.Main;

public class Exit {
    private Exit(){
        //View Exit
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(){

        System.out.println("\nExiting..\n");
        Main.runMain();
    }
}
