package com.example.buylap.database.dao;

import android.os.StrictMode;

import com.example.buylap.database.JdbcConnection;
import com.example.buylap.database.query.QueryBuild;

import com.example.buylap.exceptions.DAOException;
import com.example.buylap.model.ModelBuild;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAObuild {

    private DAObuild() {
        //Private constructor
    }
    public static ModelBuild selectBuild(String name, String keyword) throws SQLException, DAOException {
        ModelBuild modelBuild = null;
        Connection connection = null;
        Statement statement = null;

        try {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            connection = JdbcConnection.getInstance().getConnection();

            statement = connection.createStatement();
            ResultSet rs = QueryBuild.retrieveBuild(statement, name, keyword);
            if (!rs.first()) {
                throw new DAOException("Table not found with keyword " + keyword);
            }
            String recordName = rs.getString(2);
            String recordSubtitles = rs.getString(3);
            String recordUrl = rs.getString(4);
            String recordPrice = rs.getString(6);

            modelBuild = new ModelBuild(recordName, recordSubtitles, recordUrl , Float.valueOf(recordPrice));
            rs.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }

        return modelBuild;
    }
}
