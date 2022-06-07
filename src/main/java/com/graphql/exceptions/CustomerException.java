package com.graphql.exceptions;

public class CustomerException extends RuntimeException {

    private  String message;
    private  String errorCode;

    public CustomerException(String message, String errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "CustomerException {" +
                "message='" + message + '\'' +
                ", errorCode='" + errorCode + '\'' +
                '}';
    }
}
