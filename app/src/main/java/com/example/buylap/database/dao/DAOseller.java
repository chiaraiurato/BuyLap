package com.example.buylap.database.dao;

import android.os.StrictMode;

import com.example.buylap.bean.BeanSeller;
import com.example.buylap.database.JdbcConnection;
import com.example.buylap.database.Query.QueryRegistrationLogin;
import com.example.buylap.exceptions.DAOException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

public class DAOseller {

    private DAOseller() {
        //private constructor
    }
    public static void insertSeller(BeanSeller beanSeller) throws SQLException, DAOException {

        Connection connection = null;
        Statement statement = null;

        try {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            connection = JdbcConnection.getInstance().getConnection();

            statement = connection.createStatement();
            QueryRegistrationLogin.insertSeller(statement, beanSeller);

        } catch(SQLIntegrityConstraintViolationException e){
            throw new DAOException("Username repetition");
        }
    }
}
