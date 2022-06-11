package com.example.buylap.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.example.buylap.cli.Main;
import com.example.buylap.cli.graphic_controller.MainGraphicController;
import com.example.buylap.controller.graphic.NavigationGraphicController;
import com.example.buylap.R;
import com.example.buylap.utils.ContextHolder;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class NavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BottomNavigationView navigationView;
        NavigationGraphicController navigationGraphicController = new NavigationGraphicController(this);
        setContentView(R.layout.activity_homepage);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ContextHolder contextHolder = ContextHolder.getInstance();
        contextHolder.setContext(getApplicationContext());

        navigationView=findViewById(R.id.bottom_navigation);

        navigationGraphicController.checkLogin();

        navigationView.setSelectedItemId(R.id.nav_home);
        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = navigationGraphicController.switchPage(item);
                getSupportFragmentManager().beginTransaction().replace(R.id.body_container, fragment).commit();
                return true;

            }
        });
        boolean gotoCashback = this.getIntent().getBooleanExtra("gotoCashback", false);
        if(gotoCashback)
        {
            Fragment fragment = new CashbackFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.body_container, fragment).commit();
        }
    }
}