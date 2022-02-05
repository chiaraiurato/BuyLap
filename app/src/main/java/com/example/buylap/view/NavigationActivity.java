package com.example.buylap.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.example.buylap.controller.graphic.NavigationGraphicController;
import com.example.buylap.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class NavigationActivity extends AppCompatActivity {

    BottomNavigationView navigationView;
    NavigationGraphicController navigationGraphicController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.navigationGraphicController = new NavigationGraphicController(this);

        navigationView=findViewById(R.id.bottom_navigation);

        Fragment fragmentchoice =navigationGraphicController.choiceAccount();
        getSupportFragmentManager().beginTransaction().replace(R.id.body_container, fragmentchoice).commit();


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