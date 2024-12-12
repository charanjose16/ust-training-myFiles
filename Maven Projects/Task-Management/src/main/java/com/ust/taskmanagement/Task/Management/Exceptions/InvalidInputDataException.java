package com.ust.taskmanagement.Task.Management.Exceptions;

public class InvalidInputDataException extends RuntimeException{
    public InvalidInputDataException(String message){
        super(message);
    }
}
