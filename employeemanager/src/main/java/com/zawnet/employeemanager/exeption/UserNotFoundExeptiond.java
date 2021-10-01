package com.zawnet.employeemanager.exeption;

public class UserNotFoundExeptiond extends RuntimeException{
    public UserNotFoundExeptiond(String message) {
        super(message);
    }
}
