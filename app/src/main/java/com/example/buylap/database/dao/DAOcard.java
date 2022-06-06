package com.example.buylap.database.dao;

import android.os.StrictMode;

import com.example.buylap.bean.BeanCard;
import com.example.buylap.bean.BeanSession;
import com.example.buylap.cli.graphic_controller.MainGraphicController;
import com.example.buylap.database.JdbcConnection;
import com.example.buylap.database.query.QueryCreditCard;
import com.example.buylap.model.ModelCreditCard;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOcard {

    private DAOcard() {
        //private constructor
    }

    public static void insertCard(BeanCard beanCard, BeanSession beanSession) throws SQLException, IOException {

        Connection connection = null;
        Statement statement = null;

        if(!MainGraphicController.CLI) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        connection = JdbcConnection.getInstance().getConnection();

        statement = connection.createStatement();
        QueryCreditCard.insertCreditCard(statement, beanCard, beanSession);

    }

    public static ModelCreditCard searchCard(BeanSession beanSession) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ModelCreditCard modelCreditCard;
        try {

            if(!MainGraphicController.CLI) {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }
            connection = JdbcConnection.getInstance().getConnection();

            statement = connection.createStatement();
            ResultSet rs = QueryCreditCard.searchCard(statement, beanSession);
            if (!rs.first()) {
                return null;
            }
            String recordName = rs.getString(2);
            String recordNumber = rs.getString(3);
            String recordDate = rs.getString(4);
            modelCreditCard = new ModelCreditCard(recordName, recordNumber, recordDate);
            rs.close();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
        return modelCreditCard;
    }

    public static void deleteCreditCard(BeanSession beanSession) throws SQLException, IOException {
        Connection connection = null;
        Statement statement = null;
        try {

            if(!MainGraphicController.CLI) {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }
            connection = JdbcConnection.getInstance().getConnection();

            statement = connection.createStatement();
            QueryCreditCard.deleteCard(statement, beanSession);
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }
}
