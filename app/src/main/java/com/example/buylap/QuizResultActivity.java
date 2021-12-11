package com.example.buylap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.buylap.View.CashbackFragment;
import com.example.buylap.View.HomepageActivity;
import com.example.buylap.View.MainActivity;
import com.example.buylap.View.RegistrationActivity;

import java.util.ArrayList;

public class QuizResultActivity extends AppCompatActivity implements CategoryAdapter.OnCatListener{
    public static boolean update=false;

    public static boolean isUpdate() {
        return update;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        RecyclerView.Adapter adapter;
        RecyclerView recyclerViewBuild;
        Button updateAccBalance;
        recyclerViewBuild=findViewById(R.id.RecyclerBuild);
        updateAccBalance=findViewById(R.id.updateBtn);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,  LinearLayoutManager.VERTICAL, false);
        recyclerViewBuild.setLayoutManager(linearLayoutManager);
        ArrayList<Category> build = new ArrayList<>();
        build.add(new Category("Motherboard", "motherboard", "jwindwj"));
        build.add(new Category("SSD", "ssd", "swqisq"));
        build.add(new Category("CPU", "cpu", "wijskdwp"));
        build.add(new Category("Ram", "ram", "jwqosqkl"));
        build.add(new Category("Video Card", "videocard", "jswoq"));
        build.add(new Category("Power Supply", "powersupply", "jwqos"));

        adapter = new CategoryAdapter(build, this);
        recyclerViewBuild.setAdapter(adapter);
        updateAccBalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentprova = new Intent(QuizResultActivity.this, HomepageActivity.class);
                update=true;
                startActivity(intentprova);
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

            default:
                intent =  new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ebay.it/itm/294543728322?hash=item44942c9ec2:g:-hkAAOSw669f~-tk"));
                break;
        }
        this.startActivity(intent);
    }

}
