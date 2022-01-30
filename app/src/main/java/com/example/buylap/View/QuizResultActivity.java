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
import com.example.buylap.Category;
import com.example.buylap.CategoryAdapter;
import com.example.buylap.Controller.Applicativo.BuildController;
import com.example.buylap.Exceptions.DAOException;
import com.example.buylap.Model.Answer;
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
    private BeanAnswer beanAnswer;
    BeanCpu beanCPU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        this.build =  new ArrayList<>();
        this.buildController = new BuildController();
        this.beanAnswer = new BeanAnswer();

        recyclerViewBuild=findViewById(R.id.RecyclerBuild);
        updateAccBalance=findViewById(R.id.updateBtn);

        linearLayoutManager = new LinearLayoutManager(this,  LinearLayoutManager.VERTICAL, false);
        recyclerViewBuild.setLayoutManager(linearLayoutManager);


        try {
            beanCPU = buildController.createBuild("cpu", beanAnswer.getOp3());
        } catch (DAOException e) {
            e.printStackTrace();
        }

        build.add(new Category("Motherboard", "motherboard96", "jwindwj"));
        build.add(new Category("SSD", "ssd", "swqisq"));

        build.add(new Category(beanCPU.getName(), "cpu", beanCPU.getSubtitles()));
        build.add(new Category("Ram", "ram", "jwqosqkl"));
        build.add(new Category("Video Card", "videocard", "jswoq"));
        build.add(new Category("Power Supply", "powersupply", "jwqos"));

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
                intent =  new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ebay.it/itm/255269737041?hash=item3b6f431251:g:DmMAAOSwL2Nhsj~h"));
                break;

            case 1:
                intent =  new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ebay.it/itm/264260344952?hash=item3d8724dc78:g:HvMAAOSw4ARhl31Y"));
                break;
            case 2:
                intent =  new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ebay.it/itm/265432918889?hash=item3dcd08eb69:g:YicAAOSwAsphqPRU"));
                break;
            case 3:
                intent =  new Intent(Intent.ACTION_VIEW, Uri.parse(beanCPU.getUrl()));
                break;
            case 4:
                intent =  new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ebay.it/itm/294543728322?hash=item44942c9ec2:g:-hkAAOSw669f~-tk"));
                break;

            default:
                intent =  new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ebay.it/itm/294543728322?hash=item44942c9ec2:g:-hkAAOSw669f~-tk"));
                break;
        }
        this.startActivity(intent);
    }

}
