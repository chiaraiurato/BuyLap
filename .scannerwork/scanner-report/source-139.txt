package com.example.buylap.database.query;

import com.example.buylap.bean.BeanSeller;
import com.example.buylap.bean.BeanSession;
import com.example.buylap.bean.BeanUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryRegistrationLogin {

    private static final String SELECT_ALL= "SELECT * ";
    private static final String WHERE_USERNAME = "WHERE username = '";

    private QueryRegistrationLogin() {
        throw new IllegalStateException("Utility class");
    }
    public static void insertUser(Statement stmt, BeanUser beanUser) throws SQLException {

        String query = "INSERT INTO `users` (`username`,  `type`, `mail`, `password`) " +
                        "VALUES ('"+ beanUser.getUsername()+"', 'user', '"+beanUser.getEmail()+"', '"+beanUser.getPassword()+"');";
        stmt.executeUpdate(query);
    }
    public static void insertSeller(Statement stmt, BeanSeller beanSeller) throws SQLException {

        String query = "INSERT INTO `users` (`username`, `type`,  `mail`, `password`) " +
                        "VALUES ('"+ beanSeller.getUsername()+"', 'seller', '"+beanSeller.getEmail()+"', '"+beanSeller.getPassword()+"');";
        stmt.executeUpdate(query);
    }

    public static ResultSet searchUser(Statement stmt, BeanUser beanUser) throws    SQLException{
        String query = SELECT_ALL +
                        "FROM users " +
                        WHERE_USERNAME + beanUser.getUsername()+"' AND type = 'user' AND password = '"+beanUser.getPassword()+"';";
        return stmt.executeQuery(query);

    }

    public static ResultSet searchSeller(Statement stmt, BeanSeller beanSeller) throws SQLException {
        String query = SELECT_ALL +
                        "FROM users " +
                        WHERE_USERNAME+ beanSeller.getUsername()+"' AND type = 'seller' AND password = '"+beanSeller.getPassword()+"';";
        return stmt.executeQuery(query);
    }

    public static ResultSet searchPoints(Statement statement, BeanSession beanSession) throws SQLException{
        String query = SELECT_ALL +
                "FROM points_earned " +
                WHERE_USERNAME+beanSession.getUsername()+"'";
        return statement.executeQuery(query);
    }

    public static void deletePoints(Statement statement, BeanSession beanSession) throws SQLException {
        String query = "DELETE FROM points_earned " +
                WHERE_USERNAME+beanSession.getUsername()+"';";
        statement.executeUpdate(query);
    }
}
