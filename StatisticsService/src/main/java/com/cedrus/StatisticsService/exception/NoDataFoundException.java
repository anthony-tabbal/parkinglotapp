package com.cedrus.StatisticsService.exception;

public class NoDataFoundException extends RuntimeException {

    public NoDataFoundException() {

        super("No data found");
    }
}
