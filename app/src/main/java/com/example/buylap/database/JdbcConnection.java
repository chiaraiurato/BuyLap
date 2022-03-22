package com.example.buylap.database;

import android.content.Context;

import com.example.buylap.utils.PropertiesReader;
import com.example.buylap.view.MainActivity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class JdbcConnection extends MainActivity {

    private static JdbcConnection instance = null;
    private Connection connection = null;
    protected JdbcConnection() {
        //Singleton
    }
    public static synchronized JdbcConnection getInstance() throws FileNotFoundException {
        if (instance == null) {
            instance = new JdbcConnection();
        }
        return instance;
    }
       public synchronized Connection getConnection() {
        if(this.connection == null) {
            Context appContext = getContext();
            PropertiesReader propertiesReader = new PropertiesReader(appContext);
            Properties prop = propertiesReader.getProperties("db.properties");
            try{
                Class.forName("com.mysql.jdbc.Driver");
                this.connection = DriverManager.getConnection("jdbc:mysql://"+prop.getProperty("ip")+"/android",
                        prop.getProperty("username"), prop.getProperty("password"));

            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        }
            return this.connection;
        }
}

