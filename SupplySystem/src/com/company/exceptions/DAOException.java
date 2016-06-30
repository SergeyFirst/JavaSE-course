package com.company.exceptions;

public class DAOException extends Throwable {
    public DAOException() {
    }

    public DAOException(String message) {
        super(message);
    }
}
