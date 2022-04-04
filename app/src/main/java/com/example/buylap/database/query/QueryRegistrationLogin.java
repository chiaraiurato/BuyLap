package com.example.buylap.database.query;

import com.example.buylap.bean.BeanSeller;
import com.example.buylap.bean.BeanSession;
import com.example.buylap.bean.BeanUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryRegistrationLogin {

    private QueryRegistrationLogin() {
        throw new IllegalStateException("Utility class");
    }
    public static void insertUser(Statement stmt, BeanUser beanUser) throws SQLException {

        String query = "INSERT INTO `users` (`username`,  `type`, `mail`, `password`, `token`) " +
                        "VALUES ('"+ beanUser.getUsername()+"', 'user', '"+beanUser.getEmail()+"', '"+beanUser.getPassword()+"', '0');";
        stmt.executeUpdate(query);
    }
    public static void insertSeller(Statement stmt, BeanSeller beanSeller) throws SQLException {

        String query = "INSERT INTO `users` (`username`, `type`,  `mail`, `password`, `token`) " +
                        "VALUES ('"+ beanSeller.getUsername()+"', 'seller', '"+beanSeller.getEmail()+"', '"+beanSeller.getPassword()+"','0');";
        stmt.executeUpdate(query);
    }

    public static ResultSet searchUser(Statement stmt, BeanUser beanUser) throws    SQLException{
        String query = "SELECT * " +
                        "FROM users " +
                        "WHERE username = '"+ beanUser.getUsername()+"' AND type = 'user' AND password = '"+beanUser.getPassword()+"';";
        return stmt.executeQuery(query);

    }

    public static ResultSet searchSeller(Statement stmt, BeanSeller beanSeller) throws SQLException {
        String query = "SELECT * " +
                        "FROM users " +
                        "WHERE username = '"+ beanSeller.getUsername()+"' AND type = 'seller' AND password = '"+beanSeller.getPassword()+"';";
        return stmt.executeQuery(query);
    }

    public static ResultSet searchPoints(Statement statement, BeanUser beanUser) throws SQLException{
        String query = "SELECT * " +
                "FROM points_earned " +
                "WHERE username = '"+beanUser.getUsername()+"'";
        return statement.executeQuery(query);
    }

    public static void deletePoints(Statement statement, BeanSession beanSession) throws SQLException {
        String query = "DELETE FROM points_earned " +
                "WHERE username = '"+beanSession.getUsername()+"';";
        statement.executeUpdate(query);
    }
}
