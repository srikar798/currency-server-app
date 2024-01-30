package com.career.csp.service;

public class CurrencyNotFoundException extends RuntimeException{

    public CurrencyNotFoundException(String message){
        super(message);
    }

}
