package com.example.buylap.database.query;


import com.example.buylap.bean.BeanCard;
import com.example.buylap.bean.BeanSession;
import com.example.buylap.exceptions.LengthBeanCardException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryCreditCard {

    private QueryCreditCard() {
        throw new IllegalStateException("Utility class");
    }

    public static void insertCreditCard(Statement stmt, BeanCard beanCard, BeanSession beanSession) throws SQLException {
        String query = "INSERT INTO `creditcard` (`name`, `numbercard`, `date`, `username`) " +
                "VALUES ('"+ beanCard.getCardHolderName()+"', '"+beanCard.getCardNumber()+"', '"+beanCard.getData()+"-01','"+beanSession.getUsername()+"');";
        stmt.executeUpdate(query);
    }

    public static ResultSet searchCard(Statement statement, BeanSession beanSession) throws SQLException {
        String query = "SELECT * " +
                "FROM creditcard " +
                "WHERE username = '"+ beanSession.getUsername()+"';";
        return statement.executeQuery(query);
    }

    public static void deleteCard(Statement statement, BeanSession beanSession) throws SQLException {
        String query = "DELETE FROM creditcard " +
                "WHERE username = '"+beanSession.getUsername()+"';";
        statement.executeUpdate(query);
    }
}
