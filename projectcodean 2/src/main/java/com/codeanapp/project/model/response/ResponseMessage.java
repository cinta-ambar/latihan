package com.codeanapp.project.model.response;

public enum ResponseMessage {

    RESOURCE_CREATED("resource succesfully created"),
    RESOURCE_MODIFIED("resource succesfully modified"),
    RESOURCE_FOUND("resource found"),
    RESOURCE_NOT_FOUND("resource not found"),
    RESOURCE_ALREADY_EXIST("resource already exist"),
    RESOURCE_FETCHED("resource fetched"),
    DATA_INVALID("data invalid"),
    RESOURCE_DELETE("resource succesfully to delete");
    private final String message;

    ResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
