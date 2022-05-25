package com.example.buylap.database;


import com.example.buylap.utils.ContextHolder;
import com.example.buylap.utils.PropertiesReader;
import com.example.buylap.view.NavigationActivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcConnection {

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

            //PropertiesReader propertiesReader = new PropertiesReader(ContextHolder.getInstance().getContext());
            //Properties prop = propertiesReader.getProperties("db.properties");
            try{

                this.connection = DriverManager.getConnection("jdbc:mysql://10.220.152.238/android", "andro", "andro");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
            return this.connection;
        }
}

