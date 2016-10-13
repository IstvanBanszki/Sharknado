package com.sharknado.model;

public enum Location {
    
    UNKNOWN(0),
    NEW_YORK(1),
    DALLAS(2),
    LOS_ANGELES(3),
    LAS_VEGAS(4);
    
    private final int id;
    
    Location(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    public static Location valueOf(int id) {
        //iterate over all location
        for(Location location : Location.values()){
            if(location.getId() == id){
                return location;
            }
        }
        //if not found anything then return the unknown
        return UNKNOWN;
    }

}
