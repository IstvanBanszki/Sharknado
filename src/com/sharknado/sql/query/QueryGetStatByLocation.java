package com.sharknado.sql.query;

import com.sharknado.model.Chainsaw;
import com.sharknado.model.ChainsawSoldierStat;
import com.sharknado.model.ChainsawSoldierStat.Builder;
import com.sharknado.model.Location;
import com.sharknado.sql.MySqlConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QueryGetStatByLocation extends MySqlConnection {
    
    private static final String QUERY_MAIN = "SELECT l.id, sn.number, p.women_number, p.men_number FROM sharknado.chainsawnumber sn " +
                                        "INNER JOIN sharknado.chainsawtype st ON st.id = sn.chainsaw_type_id " +
                                        "INNER JOIN sharknado.location l ON l.id = sn.location_id " +
                                        "INNER JOIN sharknado.population p ON l.id = p.location_id ";
    private static final String QUERY_WHERE_GASOLINE = "WHERE st.type = 'Gasoline' ";
    private static final String QUERY_WHERE_ELECTRONIC = "WHERE st.type = 'Electronic' ";
    private static final String QUERY_GROUP_BY = "GROUP BY l.id;";
    
    public List<ChainsawSoldierStat> get(boolean electronic) {
        List<ChainsawSoldierStat> result = new ArrayList<>();
        Chainsaw type = electronic ? Chainsaw.ELECTRONIC : Chainsaw.GASOLINE;
        
        try (Connection connection = this.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet rs = statement.executeQuery(QUERY_MAIN + (electronic ? QUERY_WHERE_ELECTRONIC : QUERY_WHERE_GASOLINE ) + QUERY_GROUP_BY)) {
            
                    while (rs.next()) {
                       result.add(new Builder().setMenNumber(rs.getInt("men_number"))
                                               .setWomenNumber(rs.getInt("women_number"))
                                               .setChainSawNumber(rs.getInt("number"))
                                               .setLocation(Location.valueOf(rs.getInt("id")))
                                               .setChainSaw(type)
                                               .build());
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
