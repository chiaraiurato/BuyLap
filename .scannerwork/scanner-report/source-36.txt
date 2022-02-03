package com.example.buylap.Database.Query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryRegistration {
    public static ResultSet insertUser(Statement stmt, String username, String mail, String password) throws SQLException {

        String query = "INSERT INTO `users` (`idusers`, `username`, `mail`, `password`, `token`) VALUES ('1', '"+ username+"', '"+mail+"', '"+password+"', '0');";
        return stmt.executeQuery(query);
    }
}
