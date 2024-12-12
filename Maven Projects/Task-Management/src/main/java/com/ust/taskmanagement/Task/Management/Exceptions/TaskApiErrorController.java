package com.ust.taskmanagement.Task.Management.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TaskApiErrorController {

    @ExceptionHandler(TaskNotFoundException.class)
    public ProblemDetail handleTaskNotFoundError(TaskNotFoundException ex){
        ProblemDetail response = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        response.setDetail(ex.getMessage());
        return response;
    }


    @ExceptionHandler(InvalidInputDataException.class)
    public ProblemDetail handleInvalidDataInput(InvalidInputDataException ex){
        ProblemDetail response = ProblemDetail.forStatus(HttpStatus.NOT_ACCEPTABLE);
        response.setDetail(ex.getMessage());
        return response;
    }

}
