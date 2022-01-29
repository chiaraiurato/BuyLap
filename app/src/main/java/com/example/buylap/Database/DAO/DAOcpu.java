package com.example.buylap.Database.DAO;

import com.example.buylap.Exceptions.DAOException;
import com.example.buylap.Database.JdbcConnection;
import com.example.buylap.Database.Query.QueryCpu;
import com.example.buylap.Model.ModelCpu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOcpu {

    private DAOcpu() {
    }

    public static ModelCpu selectCpu(String keyword) throws SQLException, DAOException{
        ModelCpu cpu = null;

        Statement statement = null;
        Connection connection = null;

        try {
            connection = JdbcConnection.getInstance().getConnection();

            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = QueryCpu.retrieveCpu(statement, keyword);
            if (!rs.first()) {
                throw new DAOException("Table not found");
            }
            rs.first();
            String recordName = rs.getString(2);
            String recordSubtitles = rs.getString(3);
            String recordUrl = rs.getString(4);
            cpu = new ModelCpu(recordName, recordSubtitles, recordUrl );
            rs.close();
            statement.close();

        } finally {
            if (statement != null) {
                statement.close();
            }
        }

    return cpu;
    }
}
