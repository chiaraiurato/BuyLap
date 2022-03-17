package com.example.buylap.database.query;

import com.example.buylap.bean.BeanSeller;
import com.example.buylap.bean.BeanUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryRegistrationLogin {
    public static void insertUser(Statement stmt, BeanUser beanUser) throws SQLException {

        String query = "INSERT INTO `users` (`username`, `mail`, `password`, `token`) VALUES ('"+ beanUser.getUsername()+"', '"+beanUser.getEmail()+"', '"+beanUser.getPassword()+"', '0');";
         stmt.executeUpdate(query);
    }
    public static void insertSeller(Statement stmt, BeanSeller beanSeller) throws SQLException {

        String query = "INSERT INTO `sellers` (`businessname`, `mail`, `password`) VALUES ('"+ beanSeller.getUsername()+"', '"+beanSeller.getEmail()+"', '"+beanSeller.getPassword()+"');";
        stmt.executeUpdate(query);
    }

    public static ResultSet searchUser(Statement stmt, BeanUser beanUser) throws    SQLException{
        String query = "SELECT * FROM users WHERE username = '"+ beanUser.getUsername()+"' AND password = '"+beanUser.getPassword()+"';";
        return stmt.executeQuery(query);

    }

    public static ResultSet searchSeller(Statement stmt, BeanSeller beanSeller) throws SQLException {
        String query = "SELECT * FROM sellers WHERE businessname = '"+ beanSeller.getUsername()+"' AND password = '"+beanSeller.getPassword()+"';";
        return stmt.executeQuery(query);
    }
}
