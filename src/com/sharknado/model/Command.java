package com.sharknado.model;

public enum Command {
    
    UNKNOWN(0),
    LIST_ALL(1),
    LIST_ELECTRONIC(2),
    LIST_GASOLINE(3);
    
    private final int id;
    
    Command(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    public static Command valueOf(int id) {
        //iterate over all command
        for(Command command : Command.values()){
            if(command.getId() == id){
                return command;
            }
        }
        //if not found anything then return the unknown
        return UNKNOWN;
    }
    
}
