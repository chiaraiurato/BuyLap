package com.example.buylap.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.buylap.model.Category;
import com.example.buylap.adaptergui.CategoryAdapter;
import com.example.buylap.controller.graphic.QuizResultGraphicController;
import com.example.buylap.R;

import java.util.List;

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
        String price = this.getIntent().getExtras().getString("price");
        String beanAnswer3 = this.getIntent().getExtras().getString("beanAnswer3");

        List<Category> build = quizResultGraphicController.setBuild(beanAnswer3, price);
        RecyclerView.Adapter adapter = new CategoryAdapter(build, this);
        recyclerViewBuild.setAdapter(adapter);

        if (!build.isEmpty()){

            updateAccBalance.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    quizResultGraphicController.updateBalance(v);
                }
            });
        }
    }
    @Override
    public void onCatClick(int position) {
        this.startActivity(quizResultGraphicController.linkToEbay(position));
    }

    public void setMessageGuest(View view) {
        Toast.makeText(view.getContext(), "You can't receive cashback", Toast.LENGTH_SHORT).show();
    }
}
