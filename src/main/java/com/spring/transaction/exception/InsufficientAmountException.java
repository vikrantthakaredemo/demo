package com.spring.transaction.exception;

public class InsufficientAmountException extends RuntimeException{
    public InsufficientAmountException(String msg){
        super(msg);
    }
}
