package com.example.buylap.database.dao;

import android.os.StrictMode;

import com.example.buylap.cli.graphic_controller.MainGraphicController;
import com.example.buylap.database.JdbcConnection;
import com.example.buylap.database.query.QueryPoints;
import com.example.buylap.model.ModelCashback;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOpoints {
    private DAOpoints() {
        //Private constructor
    }
    public static ModelCashback uploadPoints(ModelCashback modelCashback, String username) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        int recordPoint;
        try {
            if(!MainGraphicController.CLI) {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }
            connection = JdbcConnection.getInstance().getConnection();

            statement = connection.createStatement();
            ResultSet rs = QueryPoints.searchPoints(statement, username);
            if (!rs.first()) {
                return modelCashback;
            }
            recordPoint = rs.getInt(3);
            modelCashback.setPoints(recordPoint);
            rs.close();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
        return modelCashback;
    }

    public static void addPoints(ModelCashback modelCashback, String username) throws SQLException{
        Connection connection = null;
        Statement statement = null;
        try {
            if(!MainGraphicController.CLI) {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }
            connection = JdbcConnection.getInstance().getConnection();

            statement = connection.createStatement();
            QueryPoints.addPoints(statement, username, modelCashback);
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    public static boolean updatePoints(ModelCashback modelCashback, String username) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        try {
            if(!MainGraphicController.CLI) {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }
            connection = JdbcConnection.getInstance().getConnection();

            statement = connection.createStatement();
            QueryPoints.updatePoints(statement, modelCashback, username);
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
        return true;
    }
}
