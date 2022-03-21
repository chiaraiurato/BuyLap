package com.example.buylap.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JdbcConnection {

    private static JdbcConnection instance = null;
    private Connection connection = null;
    protected JdbcConnection(){
        //Singleton
    }
    public static synchronized JdbcConnection getInstance() {
        if (instance == null) {
            instance = new JdbcConnection();
        }
        return instance;
    }
       public synchronized Connection getConnection() {
        if(this.connection == null) {
            try {

                this.connection = DriverManager.getConnection("jdbc:mysql://192.168.1.197/android", "andro", "andro");

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
            return this.connection;
        }
}

