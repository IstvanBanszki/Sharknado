package com.sharknado;

import com.sharknado.model.Command;
import com.sharknado.service.impl.CommandRecognizerServiceImpl;
import com.sharknado.service.impl.QueryServiceImpl;

public class Main {

    public static void main(String[] args) {
        
        Command command = new CommandRecognizerServiceImpl().recognizeCommand(args);
        String data = new QueryServiceImpl().getData(command);
        System.out.println(data);
    }
    
}
