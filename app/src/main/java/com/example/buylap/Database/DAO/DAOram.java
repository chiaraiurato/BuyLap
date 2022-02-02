package com.example.buylap.Database.DAO;

import android.os.StrictMode;

import com.example.buylap.Database.JdbcConnection;
import com.example.buylap.Exceptions.DAOException;
import com.example.buylap.Model.ModelMotherBoard;
import com.example.buylap.Model.ModelRam;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOram {
/*
    public static ModelRam selectRam(String name, String keyword) throws SQLException, DAOException {
        ModelRam modelRam;
        Connection connection = null;
        Statement statement = null;

        try {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            connection = JdbcConnection.getInstance().getConnection();

            statement = connection.createStatement();
            ResultSet rs = QueryCpu.retrieveCpu(statement, name, keyword);
            if (!rs.first()) {
                throw new DAOException("Table not found with keyword " + keyword);
            }
            String recordName = rs.getString(2);
            String recordSubtitles = rs.getString(3);
            String recordUrl = rs.getString(4);
            modelRam = new ModelRam(recordName, recordSubtitles, recordUrl );
            rs.close();


        } finally {
            if (statement != null) {
                statement.close();
            }
        }

        return modelRam;
    }

 */
}
