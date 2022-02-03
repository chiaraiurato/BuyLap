package com.example.buylap.Database.Query;

import com.example.buylap.Bean.BeanUser;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryRegistration {
    public static void insertUser(Statement stmt, BeanUser beanUser) throws SQLException {

        String query = "INSERT INTO `users` (`username`, `mail`, `password`, `token`) VALUES ('"+ beanUser.getUsername()+"', '"+beanUser.getEmail()+"', '"+beanUser.getPassword()+"', '0');";
         stmt.executeUpdate(query);
    }
}
