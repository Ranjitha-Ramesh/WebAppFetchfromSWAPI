package com.example.starwars.exceptions;

public class GraphQLException extends Throwable {
    public GraphQLException(String message) {
        super(message);
    }
}
