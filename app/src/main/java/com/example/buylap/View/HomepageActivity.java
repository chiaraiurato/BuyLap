package com.example.buylap.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.example.buylap.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomepageActivity extends AppCompatActivity {

    BottomNavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);


        navigationView=findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.body_container, new HomeFragment()).commit();
        navigationView.setSelectedItemId(R.id.nav_home);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()){
                    case R.id.nav_home:
                        fragment= new HomeFragment();
                        break;
                    case R.id.nav_cashback:
                        fragment = new CashbackFragment();
                        break;
                    case R.id.nav_like:
                        fragment= new LikeFragment();
                        break;
                    case R.id.nav_user:
                        fragment= new UserFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.body_container, fragment).commit();


                // An icon only badge will be displayed unless a number is set:
                if(QuizResultActivity.isUpdate()) {

                    BadgeDrawable badge = navigationView.getOrCreateBadge(R.id.nav_cashback);

                    badge.isVisible();
                    badge.setNumber(1);
                }
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