package com.example.buylap.database;


import com.example.buylap.cli.graphic_controller.MainGraphicController;
import com.example.buylap.utils.ContextHolder;
import com.example.buylap.utils.PropertiesReader;
import com.example.buylap.view.NavigationActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
       public synchronized Connection getConnection() throws IOException {
        if(this.connection == null) {
            if (!MainGraphicController.CLI) {
                PropertiesReader propertiesReader = new PropertiesReader(ContextHolder.getInstance().getContext());
                Properties prop = propertiesReader.getProperties("db.properties");
                try {

                    this.connection = DriverManager.getConnection("jdbc:mysql://" + prop.getProperty("ip") + "/android", prop.getProperty("username"), prop.getProperty("password"));

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                File file = new File(
                        "C:\\Users\\Chiara\\Desktop\\BuyLap\\app\\src\\main\\assets\\db.properties");
                BufferedReader br
                        = new BufferedReader(new FileReader(file));
                String username = br.readLine().replace("username=", "");
                String password = br.readLine().replace("password=", "");
                String ip = br.readLine().replace("ip=", "");

                try {

                    this.connection = DriverManager.getConnection("jdbc:mysql://" + ip + "/android", username, password);

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
            return this.connection;
        }
}

