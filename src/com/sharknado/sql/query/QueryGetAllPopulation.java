package com.sharknado.sql.query;

import com.sharknado.sql.MySqlConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryGetAllPopulation extends MySqlConnection {
    
    private static final String QUERY_WOMEN = "SELECT SUM(p.women_number) AS number FROM sharknado.population p";
    private static final String QUERY_MEN = "SELECT SUM(p.men_number) AS number FROM sharknado.population p";
    
    public int get(boolean men) {
        int result = 0;
        try (Connection connection = this.getConnection()) {
            try(Statement statement = connection.createStatement()) {
                try(ResultSet rs = statement.executeQuery(men ? QUERY_MEN : QUERY_WOMEN)) {
                   if (rs.next()) {
                       result = rs.getInt("number");
                    } 
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
