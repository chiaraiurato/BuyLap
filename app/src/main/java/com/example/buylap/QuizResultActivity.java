package com.example.buylap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.buylap.View.GamingActivity;
import com.example.buylap.View.HomeActivity;
import com.example.buylap.View.OfficeActivity;
import com.example.buylap.View.StudyActivity;

import java.util.ArrayList;

public class QuizResultActivity extends AppCompatActivity implements CategoryAdapter.OnCatListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RecyclerView.Adapter adapter;
        RecyclerView recyclerViewBuild;

        recyclerViewBuild=(RecyclerView)findViewById(R.id.RecyclerBuild);
        setContentView(R.layout.activity_quiz_result);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,  LinearLayoutManager.VERTICAL, false);
        recyclerViewBuild.setLayoutManager(linearLayoutManager);
        ArrayList<Category> build = new ArrayList<>();
        build.add(new Category("Gaming", "ic_baseline_gamepad_24"));
        build.add(new Category("Office", "ic_round_architecture_24"));
        build.add(new Category("Home", "ic_baseline_home_work_24"));
        build.add(new Category("Study", "ic_round_school_24"));

        adapter = new CategoryAdapter(build, this);
        recyclerViewBuild.setAdapter(adapter);
    }

    @Override
    public void onCatClick(int position) {
        final Intent intent;
        switch (position){
            case 0:
                intent =  new Intent(this, GamingActivity.class);
                break;

            case 1:
                intent =  new Intent(this, OfficeActivity.class);
                break;
            case 2:
                intent = new Intent(this, HomeActivity.class);
                break;

            default:
                intent =  new Intent(this, StudyActivity.class);
                break;
        }
        this.startActivity(intent);
    }
}
