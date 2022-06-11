package com.example.buylap.database.query;

import android.graphics.ColorSpace;

import com.example.buylap.bean.BeanSeller;
import com.example.buylap.bean.BeanSession;
import com.example.buylap.bean.BeanUser;
import com.example.buylap.cli.Main;
import com.example.buylap.model.users.ModelSeller;
import com.example.buylap.model.users.ModelUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryRegistrationLogin {

    private static final String SELECT_ALL= "SELECT * ";
    private static final String WHERE_USERNAME = "WHERE username = '";

    private QueryRegistrationLogin() {
        throw new IllegalStateException("Utility class");
    }
    public static void insertUser(Statement stmt, ModelUser modelUser) throws SQLException {

        String query = "INSERT INTO `users` (`username`,  `type`, `mail`, `password`) " +
                        "VALUES ('"+ modelUser.getUsername()+"', 'user', '"+modelUser.getEmail()+"', '"+modelUser.getPassword()+"');";
        stmt.executeUpdate(query);
    }
    public static void insertSeller(Statement stmt, ModelSeller modelSeller) throws SQLException {

        String query = "INSERT INTO `users` (`username`, `type`,  `mail`, `password`, `piva` ) " +
                        "VALUES ('"+ modelSeller.getUsername()+"', 'seller', '"+modelSeller.getEmail()+"', '"+modelSeller.getPassword()+"', '"+modelSeller.getP_iva()+"');";
        stmt.executeUpdate(query);
    }

    public static ResultSet searchUser(Statement stmt, ModelUser modelUser) throws    SQLException{
        String query = SELECT_ALL +
                        "FROM users " +
                        WHERE_USERNAME + modelUser.getUsername()+"' AND type = 'user' AND password = '"+modelUser.getPassword()+"';";
        return stmt.executeQuery(query);

    }

    public static ResultSet searchSeller(Statement stmt, ModelSeller modelSeller) throws SQLException {
        String query = SELECT_ALL +
                        "FROM users " +
                        WHERE_USERNAME+ modelSeller.getUsername()+"' AND type = 'seller' AND password = '"+modelSeller.getPassword()+"';";
        return stmt.executeQuery(query);
    }
}
