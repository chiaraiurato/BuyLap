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
import com.example.buylap.Bean.BeanBuild;
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
import java.util.List;

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
    private List<BeanBuild> beanBuild;
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
        this.beanBuild = new ArrayList<>();
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

            beanAnswer=quizResultController.getBeanAnswer(beanAnswer1, beanAnswer2, beanAnswer3);
            try {
                beanBuild = buildController.createBuild(beanAnswer.getOp3());
            } catch (DAOException e) {
                e.printStackTrace();
            }


        /*
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

         */
        /*
        build.add(new Category(beanMotherboard.getName(), "motherboard96", beanMotherboard.getSubtitles()));
        build.add(new Category(beanSsd.getName(), "ssd", beanSsd.getSubtitles()));

        build.add(new Category(beanCPU.getName(), "cpu", beanCPU.getSubtitles()));
        build.add(new Category(beanRam.getName(), "ram", beanRam.getSubtitles()));
        build.add(new Category(beanVideoCard.getName(), "videocard", beanVideoCard.getSubtitles()));
        build.add(new Category(beanPower.getName(), "powersupply", beanPower.getSubtitles()));


         */
        build.add(new Category(beanBuild.get(0).getName(), "motherboard96", beanBuild.get(0).getSubtitles()));
        build.add(new Category(beanBuild.get(1).getName(), "ssd", beanBuild.get(1).getSubtitles()));

        build.add(new Category(beanBuild.get(2).getName(), "cpu", beanBuild.get(2).getSubtitles()));
        build.add(new Category(beanBuild.get(3).getName(), "ram", beanBuild.get(3).getSubtitles()));
        build.add(new Category(beanBuild.get(4).getName(), "videocard", beanBuild.get(4).getSubtitles()));
        build.add(new Category(beanBuild.get(5).getName(), "powersupply", beanBuild.get(5).getSubtitles()));

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
    public void setBuildAdapter(BeanBuild beanBuild){
        this.adapter = new CategoryAdapter(build, this);
        recyclerViewBuild.setAdapter(adapter);
    }
    @Override
    public void onCatClick(int position) {

        final Intent intent;
        switch (position){
            case 0:
                intent =  new Intent(Intent.ACTION_VIEW, Uri.parse(beanBuild.get(0).getUrl()));
                break;

            case 1:
                intent =  new Intent(Intent.ACTION_VIEW, Uri.parse(beanBuild.get(1).getUrl()));
                break;
            case 2:
                intent =  new Intent(Intent.ACTION_VIEW, Uri.parse(beanBuild.get(2).getUrl()));
                break;
            case 3:
                intent =  new Intent(Intent.ACTION_VIEW, Uri.parse(beanBuild.get(3).getUrl()));
                break;
            case 4:
                intent =  new Intent(Intent.ACTION_VIEW, Uri.parse(beanBuild.get(4).getUrl()));
                break;

            default:
                intent =  new Intent(Intent.ACTION_VIEW, Uri.parse(beanBuild.get(5).getUrl()));
                break;
        }
        this.startActivity(intent);
    }

}
