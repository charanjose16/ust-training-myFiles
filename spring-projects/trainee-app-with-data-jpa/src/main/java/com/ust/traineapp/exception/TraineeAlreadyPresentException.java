package com.ust.traineapp.exception;

public class TraineeAlreadyPresentException extends RuntimeException{
    public TraineeAlreadyPresentException(String message){
        super(message);
    }
}
