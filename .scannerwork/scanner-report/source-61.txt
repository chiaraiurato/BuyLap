package com.example.buylap.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.buylap.Bean.BeanBuild;
import com.example.buylap.Category;
import com.example.buylap.CategoryAdapter;
import com.example.buylap.Controller.Grafico.QuizResultGraphicController;
import com.example.buylap.R;

public class QuizResultActivity extends AppCompatActivity implements CategoryAdapter.OnCatListener {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewBuild;
    private Button updateAccBalance;
    private LinearLayoutManager linearLayoutManager;

    private QuizResultGraphicController quizResultGraphicController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        this.quizResultGraphicController = new QuizResultGraphicController(this);

        recyclerViewBuild=findViewById(R.id.RecyclerBuild);
        updateAccBalance=findViewById(R.id.updateBtn);

        linearLayoutManager = new LinearLayoutManager(this,  LinearLayoutManager.VERTICAL, false);
        recyclerViewBuild.setLayoutManager(linearLayoutManager);

        String beanAnswer1 = this.getIntent().getExtras().getString("beanAnswer1");
        String beanAnswer2 = this.getIntent().getExtras().getString("beanAnswer2");
        String beanAnswer3 = this.getIntent().getExtras().getString("beanAnswer3");

        adapter = new CategoryAdapter(quizResultGraphicController.setBuild(beanAnswer1, beanAnswer2, beanAnswer3), this);
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
