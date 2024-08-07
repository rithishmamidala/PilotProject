package com.ust.Assessment.exception;

public class SetNameNotFoundException extends RuntimeException {

    public SetNameNotFoundException(String setName) {
        super("Set name not found: " + setName);
    }
}

