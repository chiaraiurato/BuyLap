package com.example.buylap.Database.DAO;

import android.os.StrictMode;

import com.example.buylap.Database.JdbcConnection;
import com.example.buylap.Database.Query.QueryRegistration;
import com.example.buylap.Exceptions.DAOException;
import com.example.buylap.Model.Users.ModelUser;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOuser {

    public static ModelUser insertUser(String username, String mail, String password) throws SQLException, DAOException {
        ModelUser modelUser;
        Connection connection = null;
        Statement statement = null;

        try {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            connection = JdbcConnection.getInstance().getConnection();

            statement = connection.createStatement();
            ResultSet rs = QueryRegistration.insertUser(statement, username, mail, password);
            if (!rs.first()) {
                throw new DAOException("Table not found with keyword ");
            }
            String recordName = rs.getString(2);
            String recordEmail = rs.getString(3);
            String recordPassword = rs.getString(4);
            modelUser = new ModelUser(recordName, recordEmail, recordPassword );
            rs.close();


        } finally {
            if (statement != null) {
                statement.close();
            }
        }

        return modelUser;
    }
}
