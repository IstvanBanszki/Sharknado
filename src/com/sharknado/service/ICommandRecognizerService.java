package com.sharknado.service;

import com.sharknado.model.Command;

public interface ICommandRecognizerService {
    
    Command recognizeCommand(String[] args);
}
