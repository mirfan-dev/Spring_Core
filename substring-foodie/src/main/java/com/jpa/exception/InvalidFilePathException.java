package com.jpa.exception;

public class InvalidFilePathException extends RuntimeException {

    public InvalidFilePathException(String msg){
        super(msg);
    }
    public InvalidFilePathException(){
        super("Invalid File Path");
    }
}
