package com.Project.QuizApp.Model;


import lombok.Getter;
import lombok.Setter;


public class UserResponse {

    private int id;

    private String response;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
