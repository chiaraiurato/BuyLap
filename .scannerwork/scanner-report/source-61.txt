package com.example.buylap.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.buylap.CategoryAdapter;
import com.example.buylap.controller.graphic.QuizResultGraphicController;
import com.example.buylap.R;

public class QuizResultActivity extends AppCompatActivity implements CategoryAdapter.OnCatListener {


    private QuizResultGraphicController quizResultGraphicController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        this.quizResultGraphicController = new QuizResultGraphicController(this);

        RecyclerView recyclerViewBuild=findViewById(R.id.RecyclerBuild);
        Button updateAccBalance=findViewById(R.id.updateBtn);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,  LinearLayoutManager.VERTICAL, false);
        recyclerViewBuild.setLayoutManager(linearLayoutManager);

        String beanAnswer1 = this.getIntent().getExtras().getString("beanAnswer1");
        String beanAnswer2 = this.getIntent().getExtras().getString("beanAnswer2");
        String beanAnswer3 = this.getIntent().getExtras().getString("beanAnswer3");

        RecyclerView.Adapter adapter = new CategoryAdapter(quizResultGraphicController.setBuild(beanAnswer1, beanAnswer2, beanAnswer3), this);
        recyclerViewBuild.setAdapter(adapter);

        updateAccBalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(QuizResultActivity.this, NavigationActivity.class);
                intent.putExtra("gotoCashback", true);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onCatClick(int position) {
        this.startActivity(quizResultGraphicController.linkToEbay(position));
    }

}
