package com.nada.SecureBankSystem.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String str){
        super(str);
    }
}
