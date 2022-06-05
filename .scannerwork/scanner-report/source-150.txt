package com.example.buylap.database.dao;

import android.os.StrictMode;


import com.example.buylap.bean.BeanBuild;
import com.example.buylap.bean.BeanSession;
import com.example.buylap.cli.graphic_controller.MainGraphicController;
import com.example.buylap.database.JdbcConnection;
import com.example.buylap.database.query.QueryBuild;

import com.example.buylap.model.ModelBuild;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAObuild {

    private DAObuild() {
        //Private constructor
    }
    public static ModelBuild selectBuild(String type, String nameTable, float price) throws SQLException{
        ModelBuild modelBuild = null;
        Connection connection = null;
        Statement statement = null;

        try {
            MainGraphicController mainGraphicController = new MainGraphicController();
            if(!mainGraphicController.cli) {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }
            connection = JdbcConnection.getInstance().getConnection();

            statement = connection.createStatement();
            ResultSet rs = QueryBuild.retrieveBuild(statement,type, nameTable, price);
            if (!rs.first()) {
                return modelBuild;
            }
            String recordName = rs.getString(1);
            String recordSubtitles = rs.getString(2);
            String recordUrl = rs.getString(3);
            float recordPrice = rs.getFloat(4);
            modelBuild = new ModelBuild(recordName, recordSubtitles, recordUrl , recordPrice);
            rs.close();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }

        return modelBuild;
    }

    public static void insertComponent(BeanBuild beanBuild, BeanSession beanSession) throws FileNotFoundException {
        Connection connection = null;
        Statement statement = null;

        try {
            MainGraphicController mainGraphicController = new MainGraphicController();
            if(!mainGraphicController.cli) {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }
            connection = JdbcConnection.getInstance().getConnection();

            statement = connection.createStatement();
            QueryBuild.insertComponent(statement, beanBuild, beanSession);

        } catch (SQLException e) {
           e.printStackTrace();
        }

    }
}
