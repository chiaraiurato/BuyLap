package com.example.buylap.database.dao;

import android.os.StrictMode;

import com.example.buylap.cli.graphic_controller.MainGraphicController;
import com.example.buylap.database.JdbcConnection;
import com.example.buylap.database.query.QueryRegistrationLogin;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.model.users.ModelUser;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

public class DAOuser {

    private DAOuser() {
        //private constructor
    }
    public static void insertUser(ModelUser modelUser) throws SQLException, DAOException{

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
                QueryRegistrationLogin.insertUser(statement, modelUser);
            }

        } catch(SQLIntegrityConstraintViolationException e) {
            throw new DAOException("Username repetition");
        }
    }

    public static ModelUser searchUser(ModelUser modelUser) throws SQLException, DAOException, IOException {
        Connection connection = null;
        Statement statement = null;
        try {

            if(!MainGraphicController.CLI) {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }
            connection = JdbcConnection.getInstance().getConnection();

            statement = connection.createStatement();
            ResultSet rs = QueryRegistrationLogin.searchUser(statement, modelUser);
            if (!rs.first()) {
                throw new DAOException("Entry not found");
            }
            rs.close();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
        return modelUser;
    }


}
