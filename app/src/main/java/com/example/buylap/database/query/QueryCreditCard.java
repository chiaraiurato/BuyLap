package com.example.buylap.database.query;

import com.example.buylap.bean.BeanCard;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryCreditCard {
    public static void insertCreditCard(Statement stmt, BeanCard beanCard) throws SQLException {
        String query = "INSERT INTO `creditcard` (`name`, `numbercard`, `date`, `cvv`) " +
                "VALUES ('"+ beanCard.getCardHolderName()+"', '"+beanCard.getCardNumber()+"', '"+beanCard.getData()+"','"+beanCard.getCvv()+"');";
        stmt.executeQuery(query);
    }
}
