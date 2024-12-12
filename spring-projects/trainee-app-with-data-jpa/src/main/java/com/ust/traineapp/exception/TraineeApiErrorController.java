package com.ust.traineapp.exception;

import com.ust.traineapp.dto.ErrorResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class TraineeApiErrorController {

    @ExceptionHandler(RecordNotFoundException.class)
    public ProblemDetail handleRecordNotFoundError(RecordNotFoundException ex){
        ProblemDetail response = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        response.setDetail(ex.getMessage());
        return response;
    }


    @ExceptionHandler(TraineeAlreadyPresentException.class)
    public ProblemDetail handleTraineeAlreadyPresentError(TraineeAlreadyPresentException ex){
        ProblemDetail response = ProblemDetail.forStatus(HttpStatus.CONFLICT);
        response.setDetail(ex.getMessage());
        return response;
    }


}
