package com.example.buylap.database.Query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryBuild {


    public static ResultSet retrieveBuild(Statement stmt, String name,  String keyword) throws SQLException {
        String query = "SELECT * FROM " + name + " WHERE category = '" + keyword + "';";
        return stmt.executeQuery(query);
    }


}
