package com.example.buylap.Database.Query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryCpu {


    public static ResultSet retrieveCpu(Statement stmt, String name,  String keyword) throws SQLException {
        String query = "SELECT * FROM " + name + " WHERE category = '" + keyword + "';";
        return stmt.executeQuery(query);
    }


}
