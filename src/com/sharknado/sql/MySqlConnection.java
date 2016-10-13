package com.sharknado.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
    
    //Constant strings
    private static final String URL = "jdbc:mysql://localhost:3306/sharknado?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

}
