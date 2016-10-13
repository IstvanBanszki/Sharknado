package com.sharknado.service.impl;

import com.sharknado.model.Command;
import com.sharknado.service.ICommandRecognizerService;

public class CommandRecognizerServiceImpl implements ICommandRecognizerService {
 
    @Override
    public Command recognizeCommand(String[] args) {
        Command result = Command.UNKNOWN;
        
        if (args.length > 0){

            if (args[0].equals("-e")) {
                result = Command.LIST_ELECTRONIC;
            } else if (args[0].equals("-g")) {
                result = Command.LIST_GASOLINE;
            }
        } else {
            result = Command.LIST_ALL;
        }
        return result;
    }
}
