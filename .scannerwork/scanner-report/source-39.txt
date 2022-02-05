package com.example.buylap.Database.DAO;

import android.os.StrictMode;

import com.example.buylap.Bean.BeanSeller;
import com.example.buylap.Database.JdbcConnection;
import com.example.buylap.Database.Query.QueryRegistrationLogin;
import com.example.buylap.Exceptions.DAOException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

public class DAOseller {
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
