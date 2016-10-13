package com.sharknado.sql.query;

import com.sharknado.sql.MySqlConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryGetAllChainsaw extends MySqlConnection {
    
    private static final String QUERY = "SELECT SUM(sn.number) AS number FROM sharknado.chainsawnumber sn " +
                                        "INNER JOIN sharknado.chainsawtype st ON st.id = sn.chainsaw_type_id " +
                                        "WHERE st.type = ";
    private static final String ELECTRONIC = "'Electronic'";
    private static final String GASOLINE = "'Gasoline'";
    
    public int get(boolean electronic) {
        int result = 0;

        try (Connection connection = this.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet rs = statement.executeQuery(QUERY + (electronic ? ELECTRONIC : GASOLINE))) {
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
