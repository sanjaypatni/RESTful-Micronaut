package com.pluralsight.smart.oven.exception;

public class InvalidTemperatureException extends RuntimeException {

    public InvalidTemperatureException(String message) {
        super(message);
    }
}
