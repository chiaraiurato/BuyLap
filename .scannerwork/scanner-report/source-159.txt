package com.example.buylap.database.query;

import com.example.buylap.model.ModelBuild;
import com.example.buylap.model.users.ModelSeller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryBuild {


    private QueryBuild() {
        throw new IllegalStateException("Utility class");
    }

    public static ResultSet retrieveBuild(Statement stmt, String type, String nameTable, float price) throws SQLException {
        float firstPrice = price - 200;
        float secondPrice = price + 200;
        String query = "SELECT "+nameTable+"."+type+", "+type+".subtitles, "+type+".url, "+type+".price " +
                        "FROM " +nameTable+ " " +
                        "INNER JOIN "+type+" ON "+nameTable+"."+type+"="+type+".name "+
                        "WHERE `price_total` BETWEEN "+ firstPrice +" AND "+secondPrice+";";
       
        return stmt.executeQuery(query);
    }


    public static void insertComponent(Statement statement, ModelBuild modelBuild, ModelSeller modelSeller) throws SQLException {
        String query = "INSERT INTO `insert_component` (`username`, `type`, `name`,  `subtitles`,`price`, `url`) " +
                "VALUES ('"+modelSeller.getUsername() +"', '"+ modelBuild.getType()+"', '"+modelBuild.getTitle()+"', '"+modelBuild.getSubtitles()+"', '"
                + modelBuild.getPrice()+"', ' "+ modelBuild.getUrlEbay()+"');";
        statement.executeUpdate(query);
    }
}
