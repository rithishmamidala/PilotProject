package com.ust.Assessment.exception;

public class SetIdNotFoundException extends RuntimeException{
    public SetIdNotFoundException(Integer setId) {
        super("Set ID not found: " + setId);
    }
}
