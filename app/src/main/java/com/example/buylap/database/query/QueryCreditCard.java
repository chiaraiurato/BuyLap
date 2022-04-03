package com.example.buylap.database.query;

import android.util.Log;

import com.example.buylap.bean.BeanCard;
import com.example.buylap.bean.BeanSession;
import com.example.buylap.bean.BeanUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryCreditCard {
    public static void insertCreditCard(Statement stmt, BeanCard beanCard, BeanSession beanSession) throws SQLException {
        String query = "INSERT INTO `creditcard` (`name`, `numbercard`, `date`, `cvv`, `username`) " +
                "VALUES ('"+ beanCard.getCardHolderName()+"', '"+beanCard.getCardNumber()+"', '"+beanCard.getData()+"-01','"+beanCard.getCvv()+"','"+beanSession.getUsername()+"');";
        stmt.executeUpdate(query);
    }

    public static ResultSet searchCard(Statement statement, BeanUser beanUser) throws SQLException {
        String query = "SELECT * " +
                "FROM creditcard " +
                "WHERE username = '"+ beanUser.getUsername()+"';";
        return statement.executeQuery(query);
    }

    public static void deleteCard(Statement statement, BeanSession beanSession) throws SQLException {
        String query = "DELETE FROM creditcard " +
                "WHERE username = '"+beanSession.getUsername()+"';";
        statement.executeUpdate(query);
    }
}
