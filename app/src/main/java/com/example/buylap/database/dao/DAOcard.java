package com.example.buylap.database.dao;

import android.os.StrictMode;

import com.example.buylap.bean.BeanCard;
import com.example.buylap.bean.BeanSession;
import com.example.buylap.bean.BeanUser;
import com.example.buylap.database.JdbcConnection;
import com.example.buylap.database.query.QueryBuild;
import com.example.buylap.database.query.QueryCreditCard;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.model.ModelBuild;
import com.example.buylap.model.ModelCreditCard;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOcard {

    private DAOcard(){
        //private constructor
    }
    public static void insertCard(BeanCard beanCard, BeanSession beanSession) throws SQLException, FileNotFoundException {

        Connection connection = null;
        Statement statement = null;

        try {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            connection = JdbcConnection.getInstance().getConnection();

            statement = connection.createStatement();
            QueryCreditCard.insertCreditCard(statement, beanCard, beanSession);

        } catch (FileNotFoundException e ) {
            throw new FileNotFoundException("file not found");
        }
    }
}
