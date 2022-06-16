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
    public synchronized Connection getConnection() {

        if (this.connection == null) {
            if (!MainGraphicController.CLI) {
               androidMode();
            } else {
                String path = new File("").getAbsolutePath();

                File file = new File(
                        path + "\\app\\src\\main\\assets\\db.properties");
                cliMode(file);
            }
        }
        return this.connection;
    }
    private void androidMode() {
        PropertiesReader propertiesReader = new PropertiesReader(ContextHolder.getInstance().getContext());
        Properties prop = propertiesReader.getProperties("db.properties");
        try {

            this.connection = DriverManager.getConnection("jdbc:mysql://" + prop.getProperty("ip") + "/android", prop.getProperty("username"), prop.getProperty("password"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void cliMode(File file) {

        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String str = null;
            StringBuilder strb = new StringBuilder();
            while ((str = br.readLine()) != null) {
                strb.append(str);
            }

            String username = strb.toString().replace("username=", "").substring(0, 5);

            String password = strb.toString().replace("password=", "").substring(9, 14);

            String ip = strb.toString().replace("ip=", "").substring(28);

            this.connection = DriverManager.getConnection("jdbc:mysql://" + ip + "/android", username, password);

        } catch (FileNotFoundException f) {

            System.out.println(file + " does not exist");

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}


