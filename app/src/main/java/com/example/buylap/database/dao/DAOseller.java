package com.example.buylap.database.dao;
import android.os.StrictMode;

import com.example.buylap.bean.BeanSeller;
import com.example.buylap.cli.graphic_controller.MainGraphicController;
import com.example.buylap.database.JdbcConnection;
import com.example.buylap.database.query.QueryRegistrationLogin;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.model.users.ModelSeller;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

public class DAOseller {

    private DAOseller() {
        //private constructor
    }
    public static void insertSeller(ModelSeller modelSeller) throws SQLException, DAOException, FileNotFoundException {

        Connection connection = null;
        Statement statement = null;

        try {

            if(!MainGraphicController.CLI) {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }
            connection = JdbcConnection.getInstance().getConnection();

            statement = connection.createStatement();
            QueryRegistrationLogin.insertSeller(statement, modelSeller);

        } catch (SQLIntegrityConstraintViolationException e) {
            throw new DAOException("Username repetition");
        }
    }

    public static ModelSeller searchSeller(BeanSeller beanSeller) throws SQLException, DAOException, IOException {
        Connection connection = null;
        Statement statement = null;
        ModelSeller modelSeller;
        try {
            if(!MainGraphicController.CLI) {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }
            connection = JdbcConnection.getInstance().getConnection();

            statement = connection.createStatement();
            ResultSet rs = QueryRegistrationLogin.searchSeller(statement, beanSeller);
            if (!rs.first()) {
                throw new DAOException("Table not found");
            }
            String recordEmail = rs.getString(3);
            modelSeller = new ModelSeller(beanSeller.getUsername(), recordEmail, beanSeller.getPassword(), beanSeller.getIva());
            rs.close();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
        return modelSeller;
    }
}

