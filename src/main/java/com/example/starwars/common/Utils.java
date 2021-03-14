package com.example.starwars.common;

import com.example.starwars.models.Error;
public class Utils {
    private Utils(){}

    //concatenates all the errors and returns as a string
    public static String getErrorMessage(Error[] errors){
        var message = new StringBuilder();
        for (var error: errors) {
            for(var loc : error.getLocations()){
                var line = loc.getLine();
                var col = loc.getColumn();
                message.append(String.format("Error: %s at line: %s, column: %s %n", error.getMessage(),line, col));
            }
        }
        return message.toString();
    }
}
