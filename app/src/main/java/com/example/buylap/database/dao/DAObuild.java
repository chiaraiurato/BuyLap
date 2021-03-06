package com.example.buylap.database.dao;

import android.os.StrictMode;


import com.example.buylap.cli.graphic_controller.MainGraphicController;
import com.example.buylap.database.JdbcConnection;
import com.example.buylap.database.query.QueryBuild;

import com.example.buylap.model.ModelBuild;
import com.example.buylap.model.ModelRequestBuild;
import com.example.buylap.model.users.ModelSeller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAObuild {

    private DAObuild() {
        //Private constructor
    }
    public static ModelBuild selectBuild(String type, String nameTable, ModelRequestBuild modelRequestBuild) throws SQLException, IOException {
        ModelBuild modelBuild = null;
        Connection connection = null;
        Statement statement = null;

        try {
            if(!MainGraphicController.CLI) {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }
            connection = JdbcConnection.getInstance().getConnection();
            if(connection != null) {
                statement = connection.createStatement();
                ResultSet rs = QueryBuild.retrieveBuild(statement, type, nameTable, modelRequestBuild.getPrice());
                if (!rs.first()) {
                    return modelBuild;
                }
                String recordName = rs.getString(1);
                String recordSubtitles = rs.getString(2);
                String recordUrl = rs.getString(3);
                float recordPrice = rs.getFloat(4);
                modelBuild = new ModelBuild(type, recordName, recordSubtitles, recordUrl, recordPrice);
                rs.close();
            }
        } finally {
            if (statement != null) {
                statement.close();
            }
        }

        return modelBuild;
    }

    public static void insertComponent(ModelSeller modelSeller, ModelBuild modelBuild) throws FileNotFoundException {
        Connection connection = null;
        Statement statement = null;

        try {
            if(!MainGraphicController.CLI) {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }
            connection = JdbcConnection.getInstance().getConnection();

            statement = connection.createStatement();
            QueryBuild.insertComponent(statement, modelBuild, modelSeller);

        } catch (SQLException e) {
           e.printStackTrace();
        }

    }
}
