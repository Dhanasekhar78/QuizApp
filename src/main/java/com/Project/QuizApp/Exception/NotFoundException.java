package com.Project.QuizApp.Exception;

import org.springframework.http.HttpStatus;

public class NotFoundException {

    private HttpStatus http;

    private String errorMessage;

    public NotFoundException(HttpStatus http, String errorMessage) {
        this.http = http;
        this.errorMessage = errorMessage;
    }

    public HttpStatus getHttp() {
        return http;
    }

    public void setHttp(HttpStatus http) {
        this.http = http;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
