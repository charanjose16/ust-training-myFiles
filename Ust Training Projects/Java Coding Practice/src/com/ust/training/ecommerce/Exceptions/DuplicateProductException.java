package com.ust.training.ecommerce.Exceptions;

public class DuplicateProductException extends Exception{
    public DuplicateProductException(String message) {
        super(message);
    }
}
