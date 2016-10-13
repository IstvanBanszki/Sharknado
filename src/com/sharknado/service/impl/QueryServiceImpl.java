package com.sharknado.service.impl;

import com.sharknado.model.ChainsawSoldierStat;
import com.sharknado.model.Command;
import com.sharknado.service.IQueryService;
import com.sharknado.sql.query.QueryGetAllChainsaw;
import com.sharknado.sql.query.QueryGetAllPopulation;
import com.sharknado.sql.query.QueryGetStatByLocation;
import java.util.List;

public class QueryServiceImpl implements IQueryService {

    private final QueryGetAllChainsaw queryGetAllChainsaw;
    private final QueryGetAllPopulation queryGetAllPopulation;
    private final QueryGetStatByLocation QueryGetStatByLocation;

    public QueryServiceImpl() {
        this.queryGetAllChainsaw = new QueryGetAllChainsaw();
        this.queryGetAllPopulation = new QueryGetAllPopulation();
        this.QueryGetStatByLocation = new QueryGetStatByLocation();
    }

    @Override
    public String getData(Command command) {

        StringBuilder sb = new StringBuilder("Result of the task!\n");

        switch (command) {
            case LIST_ELECTRONIC:
                gatherAllStatData(sb, true);
                break;
            case LIST_GASOLINE:
                gatherAllStatData(sb, false);
                break;
            case LIST_ALL:
                gatherAllInformation(sb);
                break;
            default:
                gatherHelp(sb);
                break;
        }
        return sb.toString();
    }

    private StringBuilder gatherAllStatData(StringBuilder sb, boolean electronic) {
        List<ChainsawSoldierStat> data = this.QueryGetStatByLocation.get(electronic);
        
        for (ChainsawSoldierStat single : data) {
            int chainSawNumber = single.getChainSawNumber() / 2;
            int menNumber = single.getMenNumber();
            int womenNumber = single.getWomenNumber();

            sb.append("ChainSawSoldier: \n\tLocation:");
            sb.append(single.getLocation());
            sb.append("\n\tMen Soldier number:");
            sb.append(chainSawNumber <= menNumber ? chainSawNumber : menNumber - chainSawNumber);
            sb.append("\n\tWomen Soldier number:");
            sb.append(chainSawNumber <= womenNumber ? chainSawNumber : womenNumber - chainSawNumber);
            sb.append("\n");
        }
        return sb.append("\n");
    }

    private StringBuilder gatherAllInformation(StringBuilder sb) {
        sb.append("Number of all electronic chainsaw: ");
        sb.append(this.queryGetAllChainsaw.get(true));
        sb.append("\nNumber of all gasoline chainsaw: ");
        sb.append(this.queryGetAllChainsaw.get(false));
        sb.append("\nNumber of all men: ");
        sb.append(this.queryGetAllPopulation.get(true));
        sb.append("\nNumber of all women: ");
        sb.append(this.queryGetAllPopulation.get(false));
        return sb;
    }

    private StringBuilder gatherHelp(StringBuilder sb) {
        sb.append("Unrecognizebla command!\n");
        sb.append("Command list:\n");
        sb.append("\tWith no arguments, all data will be written out!\n");
        sb.append("\tWith -e, all electronic soldier statistic data will be written out!\n");
        sb.append("\tWith -g, all gasoline soldier statistic data will be written out!\n");
        return sb;
    }
    
}
