package com.Project.QuizApp.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MyException.class)
    public ResponseEntity<Map<String, NotFoundException>>  handleMyException(MyException ex) {
        NotFoundException exception = new NotFoundException(HttpStatus.NOT_FOUND, ex.getMessage() );

        Map<String, NotFoundException> FinalException = new HashMap<>();

        FinalException.put("exception", exception);

        return new ResponseEntity<>(FinalException,HttpStatus.NOT_FOUND);
    }

    // Other exception handlers if needed
}
