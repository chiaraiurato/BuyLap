package com.example.buylap.database.query;

import com.example.buylap.bean.BeanBuild;
import com.example.buylap.bean.BeanSession;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryBuild {


    private QueryBuild() {
        throw new IllegalStateException("Utility class");
    }

    public static ResultSet retrieveBuild(Statement stmt, String name,  String keyword) throws SQLException {
        String query = "SELECT * " +
                        "FROM " + name + " " +
                        "WHERE category = '" + keyword + "';";
        return stmt.executeQuery(query);
    }


    public static void insertComponent(Statement statement, BeanBuild beanBuild, BeanSession beanSession) throws SQLException {
        String query = "INSERT INTO `"+beanBuild.getType()+"` (`name`,  `subtitles`, `url`, `price`, `username`) " +
                "VALUES ('"+ beanBuild.getTitle()+"', '"+beanBuild.getSubtitles()+"', '"+beanBuild.getUrlEbay()+"', '"
                + beanBuild.getPrice()+"', '"+beanSession.getUsername()+"');";
        statement.executeUpdate(query);
    }
}
