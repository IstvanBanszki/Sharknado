package com.sharknado.model;

public enum Chainsaw {
    
    UNKNOWN(0),
    ELECTRONIC(1),
    GASOLINE(2);
    
    private final int id;
    
    Chainsaw(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    public static Chainsaw valueOf(int id) {
        //iterate over all chainsaw
        for(Chainsaw chainsaw : Chainsaw.values()){
            if(chainsaw.getId() == id){
                return chainsaw;
            }
        }
        //if not found anything then return the unknown
        return UNKNOWN;
    }
    
}
