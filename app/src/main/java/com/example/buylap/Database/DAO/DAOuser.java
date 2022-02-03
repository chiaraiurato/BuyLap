package com.example.buylap.Database.DAO;

import android.os.StrictMode;

import com.example.buylap.Bean.BeanUser;
import com.example.buylap.Database.JdbcConnection;
import com.example.buylap.Database.Query.QueryRegistration;
import com.example.buylap.Exceptions.DAOException;
import com.example.buylap.Model.Users.ModelUser;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

public class DAOuser {

    public static void insertUser(BeanUser beanUser) throws SQLException, DAOException {

        Connection connection = null;
        Statement statement = null;

        try {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            connection = JdbcConnection.getInstance().getConnection();

            statement = connection.createStatement();
            QueryRegistration.insertUser(statement, beanUser);

        } catch(SQLIntegrityConstraintViolationException e){
            throw new DAOException("Username repetition");
        }
    }
}
