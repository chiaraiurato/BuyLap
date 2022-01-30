package com.example.buylap.Database;
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
           try {
                Class.forName("com.mysql.jdbc.Driver");
                if(this.connection == null ) {
                    this.connection = DriverManager.getConnection("jdbc:mysql://192.168.182.44:3306/android", "andro", "andro");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return connection;
        }
}

