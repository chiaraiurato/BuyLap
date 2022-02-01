package com.example.buylap.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.buylap.Bean.BeanAnswer;
import com.example.buylap.Bean.BeanCpu;
import com.example.buylap.Bean.BeanMotherboard;
import com.example.buylap.Bean.BeanPower;
import com.example.buylap.Bean.BeanRam;
import com.example.buylap.Bean.BeanSsd;
import com.example.buylap.Bean.BeanVideoCard;
import com.example.buylap.Category;
import com.example.buylap.CategoryAdapter;
import com.example.buylap.Controller.Applicativo.BuildController;
import com.example.buylap.Controller.Applicativo.QuizResultController;
import com.example.buylap.Exceptions.DAOException;
import com.example.buylap.R;

import java.util.ArrayList;

public class QuizResultActivity extends AppCompatActivity implements CategoryAdapter.OnCatListener {
    public static boolean update=false;

    public static boolean isUpdate() {
        return update;
    }

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewBuild;
    private Button updateAccBalance;
    private ArrayList<Category> build;
    private LinearLayoutManager linearLayoutManager;
    private BuildController buildController;
    private QuizResultController quizResultController;
    private String beanAnswer1;
    private String beanAnswer2;
    private String beanAnswer3;
    private BeanAnswer beanAnswer;
    BeanCpu beanCPU;
    BeanPower beanPower;
    BeanRam beanRam;
    BeanSsd beanSsd;
    BeanVideoCard beanVideoCard;
    BeanMotherboard beanMotherboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        this.build =  new ArrayList<>();
        this.buildController = new BuildController();
        this.quizResultController = new QuizResultController();

        this.beanAnswer = new BeanAnswer();
        this.beanCPU = new BeanCpu();
        this.beanSsd = new BeanSsd();
        this.beanVideoCard = new BeanVideoCard();
        this.beanRam = new BeanRam();
        this.beanPower = new BeanPower();
        recyclerViewBuild=findViewById(R.id.RecyclerBuild);
        updateAccBalance=findViewById(R.id.updateBtn);

        linearLayoutManager = new LinearLayoutManager(this,  LinearLayoutManager.VERTICAL, false);
        recyclerViewBuild.setLayoutManager(linearLayoutManager);

        beanAnswer1 = this.getIntent().getExtras().getString("beanAnswer1");
        beanAnswer2 = this.getIntent().getExtras().getString("beanAnswer2");
        beanAnswer3 = this.getIntent().getExtras().getString("beanAnswer3");

        beanAnswer=quizResultController.getBeanAnswer(beanAnswer1, beanAnswer2, beanAnswer3);


        try {
            beanCPU = buildController.createBuildCpu(beanAnswer.getOp3());
        } catch (DAOException e) {
            e.printStackTrace();
        }
        try {
            beanMotherboard = buildController.createBuildMotherBoard(beanAnswer.getOp3());
        } catch (DAOException e) {
            e.printStackTrace();
        }
        try {
            beanRam = buildController.createBuildRam(beanAnswer.getOp3());
        } catch (DAOException e) {
            e.printStackTrace();
        }
        try {
            beanPower = buildController.createBuildPower(beanAnswer.getOp3());
        } catch (DAOException e) {
            e.printStackTrace();
        }
        try {
            beanVideoCard = buildController.createBuildVideo(beanAnswer.getOp3());
        } catch (DAOException e) {
            e.printStackTrace();
        }
        try {
            beanSsd = buildController.createBuildSsd(beanAnswer.getOp3());
        } catch (DAOException e) {
            e.printStackTrace();
        }

        build.add(new Category(beanMotherboard.getName(), "motherboard96", beanMotherboard.getSubtitles()));
        build.add(new Category(beanSsd.getName(), "ssd", beanSsd.getSubtitles()));

        build.add(new Category(beanCPU.getName(), "cpu", beanCPU.getSubtitles()));
        build.add(new Category(beanRam.getName(), "ram", beanRam.getSubtitles()));
        build.add(new Category(beanVideoCard.getName(), "videocard", beanVideoCard.getSubtitles()));
        build.add(new Category(beanPower.getName(), "powersupply", beanPower.getSubtitles()));

        adapter = new CategoryAdapter(build, this);
        recyclerViewBuild.setAdapter(adapter);
        updateAccBalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(QuizResultActivity.this, HomepageActivity.class);
                update=true;
                intent.putExtra("gotoCashback", true);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onCatClick(int position) {

        final Intent intent;
        switch (position){
            case 0:
                intent =  new Intent(Intent.ACTION_VIEW, Uri.parse(beanMotherboard.getUrl()));
                break;

            case 1:
                intent =  new Intent(Intent.ACTION_VIEW, Uri.parse(beanSsd.getUrl()));
                break;
            case 2:
                intent =  new Intent(Intent.ACTION_VIEW, Uri.parse(beanCPU.getUrl()));
                break;
            case 3:
                intent =  new Intent(Intent.ACTION_VIEW, Uri.parse(beanRam.getUrl()));
                break;
            case 4:
                intent =  new Intent(Intent.ACTION_VIEW, Uri.parse(beanVideoCard.getUrl()));
                break;

            default:
                intent =  new Intent(Intent.ACTION_VIEW, Uri.parse(beanPower.getUrl()));
                break;
        }
        this.startActivity(intent);
    }

}
