package com.example.buylap.database.query;


import com.bumptech.glide.load.model.Model;
import com.example.buylap.bean.BeanCard;
import com.example.buylap.bean.BeanSession;
import com.example.buylap.exceptions.LengthBeanCardException;
import com.example.buylap.model.ModelCreditCard;
import com.example.buylap.model.users.ModelUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryCreditCard {

    private QueryCreditCard() {
        throw new IllegalStateException("Utility class");
    }

    public static void insertCreditCard(Statement stmt, ModelCreditCard creditCard, String username) throws SQLException {
        String query = "INSERT INTO `creditcard` (`name`, `numbercard`, `date`, `username`) " +
                "VALUES ('"+ creditCard.getName()+"', '"+creditCard.getNumber()+"', '"+creditCard.getData()+"-01','"+username+"');";
        stmt.executeUpdate(query);
    }

    public static ResultSet searchCard(Statement statement, String username) throws SQLException {
        String query = "SELECT * " +
                "FROM creditcard " +
                "WHERE username = '"+ username+"';";
        return statement.executeQuery(query);
    }

    public static void deleteCard(Statement statement, String username) throws SQLException {
        String query = "DELETE FROM creditcard " +
                "WHERE username = '"+username+"';";
        statement.executeUpdate(query);
    }
}
