package com.example.trial.entities.enums;

public enum ActionType {
    WITHDRAWAL("WITHDRAWAL"),
    DEPOSIT("DEPOSIT");

    private final String message;

    ActionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
