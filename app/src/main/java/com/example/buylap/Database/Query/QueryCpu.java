package com.example.buylap.Database.Query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryCpu {


    public static ResultSet retrieveCpu(Statement stmt, String keyword) throws SQLException {
        String query = String.format("SELECT * FROM cpu where category='%d';", keyword);
        return stmt.executeQuery(query);
    }


}
