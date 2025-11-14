package com.codeanapp.project.model.enumm;

public enum StackEnum {

    FRONT_END("frontend"),
    BACK_END("backend");

    private final String message;

    StackEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
