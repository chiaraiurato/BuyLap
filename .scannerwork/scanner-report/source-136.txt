package com.example.buylap.database;

import android.content.Context;

import com.example.buylap.utils.ContextHolder;
import com.example.buylap.utils.PropertiesReader;
import com.example.buylap.view.MainActivity;
import com.example.buylap.view.NavigationActivity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class JdbcConnection extends NavigationActivity {

    private static JdbcConnection instance = null;
    private Connection connection = null;
    protected JdbcConnection() {
        //Singleton
    }
    public static synchronized JdbcConnection getInstance(){
        if (instance == null) {
            instance = new JdbcConnection();
        }
        return instance;
    }
       public synchronized Connection getConnection() {
        if(this.connection == null) {

            PropertiesReader propertiesReader = new PropertiesReader(ContextHolder.getInstance().getContext());
            Properties prop = propertiesReader.getProperties("db.properties");
            try{

                this.connection = DriverManager.getConnection("jdbc:mysql://"+prop.getProperty("ip")+"/android",
                        prop.getProperty("username"), prop.getProperty("password"));

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
            return this.connection;
        }
}

