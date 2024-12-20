package com.Project.QuizApp.Model;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String title;


    @ManyToMany
    private List<Question> Question;

    public Quiz() {
    }

    public Quiz(int id, String title, List<com.Project.QuizApp.Model.Question> question) {
        Id = id;
        this.title = title;
        Question = question;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<com.Project.QuizApp.Model.Question> getQuestion() {
        return Question;
    }

    public void setQuestion(List<com.Project.QuizApp.Model.Question> question) {
        Question = question;
    }
}
