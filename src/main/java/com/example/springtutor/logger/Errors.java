package com.example.springtutor.logger;

public class Errors {
    public static String getError(String message){
        String error = "";
        for (int i = 0; i < message.length(); i++) {
            if(message.charAt(i) == '=')
                while (true){
                    i++;
                    if(message.charAt(i) == ',')
                        return error;
                    error += message.charAt(i);
                }
        }
        return error;
    }
}
