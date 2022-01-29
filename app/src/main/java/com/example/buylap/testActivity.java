package com.example.buylap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class testActivity extends AppCompatActivity {
    TextView testDb, errorText;
    Button showRecords;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        testDb=findViewById(R.id.testDb);
        errorText=findViewById(R.id.testError);
        showRecords=findViewById(R.id.showRecords);
        showRecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Task().execute();
            }
        });

    }
    class Task extends AsyncTask<Void,Void, Void >{
            String records="", error = "";

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                    Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.1.198:3306/android", "andro", "andro");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM cpu");
                while(resultSet.next()){
                    records += resultSet.getString(1) + " " + resultSet.getString(2) + "\n";
                }
            }catch (Exception e){
                e.toString();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            testDb.setText(records);
            if(error != "")
                errorText.setText(error);
            super.onPostExecute(unused);
        }
    }
}