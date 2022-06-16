package com.example.buylap.database.query;

import com.example.buylap.model.ModelCashback;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryPoints {
    private static final String SELECT_ALL= "SELECT * ";
    private static final String WHERE_USERNAME = "WHERE username = '";

    private QueryPoints(){
        throw new IllegalStateException("Utility class");
    }
    public static void updatePoints(Statement statement, ModelCashback modelCashback, String username) throws SQLException {
        String query = "UPDATE points_earned " +
                "SET token = " + modelCashback.getPoints()+ " " +
                WHERE_USERNAME+username+"'";
        statement.executeUpdate(query);
    }
    public static ResultSet searchPoints(Statement statement, String username) throws SQLException {
        String query = SELECT_ALL +
                "FROM points_earned " +
                WHERE_USERNAME+username+"'";
        return statement.executeQuery(query);
    }

    public static void addPoints(Statement statement, String username, ModelCashback modelCashback) throws SQLException {
        String query = "INSERT INTO `points_earned` (`username`,  `token`) " +
                "VALUES ('"+ username+"', '"+ modelCashback.getPoints()+"');";
        statement.executeUpdate(query);
    }
}
