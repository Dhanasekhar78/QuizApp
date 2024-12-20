package com.Project.QuizApp.Controller;

import com.Project.QuizApp.Model.Question;
import com.Project.QuizApp.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("get/allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){

        return questionService.getAllQuestions();

    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getById(@PathVariable String category){

        return questionService.getById(category);

    }

    @PostMapping("/addQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){

        return questionService.addQuestion(question);

    }
}
