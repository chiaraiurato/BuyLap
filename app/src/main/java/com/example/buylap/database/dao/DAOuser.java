package com.example.buylap.database.dao;

import android.os.StrictMode;

import com.example.buylap.bean.BeanUser;
import com.example.buylap.database.JdbcConnection;
import com.example.buylap.database.Query.QueryRegistrationLogin;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.model.Users.ModelUser;
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
            QueryRegistrationLogin.insertUser(statement, beanUser);

        } catch(SQLIntegrityConstraintViolationException e){
            throw new DAOException("Username repetition");
        }
    }

    public static ModelUser searchUser(BeanUser beanUser) throws SQLException, DAOException {
        Connection connection = null;
        Statement statement = null;
        ModelUser modelUser;
        try {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            connection = JdbcConnection.getInstance().getConnection();

            statement = connection.createStatement();
            ResultSet rs = QueryRegistrationLogin.searchUser(statement, beanUser);
            if (!rs.first()) {
                throw new DAOException("Table not found");
            }
            String recordEmail = rs.getString(3);
            modelUser = new ModelUser(beanUser.getUsername(), recordEmail, beanUser.getPassword());
            rs.close();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
        return modelUser;
    }
}
