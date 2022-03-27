package com.example.buylap.database.query;

import android.util.Log;

import com.example.buylap.bean.BeanCard;
import com.example.buylap.bean.BeanUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryCreditCard {
    public static void insertCreditCard(Statement stmt, BeanCard beanCard, BeanUser beanUser) throws SQLException {
        String query = "INSERT INTO `creditcard` (`name`, `numbercard`, `date`, `cvv`, `username`) " +
                "VALUES ('"+ beanCard.getCardHolderName()+"', '"+beanCard.getCardNumber()+"', '"+beanCard.getData()+"','"+beanCard.getCvv()+"','"+beanUser.getUsername()+"');";
        stmt.executeUpdate(query);
    }
}
