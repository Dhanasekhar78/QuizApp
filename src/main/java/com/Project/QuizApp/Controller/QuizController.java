package com.Project.QuizApp.Controller;

import com.Project.QuizApp.Model.Question;
import com.Project.QuizApp.Model.QuestionWrapper;
import com.Project.QuizApp.Model.Quiz;
import com.Project.QuizApp.Model.UserResponse;
import com.Project.QuizApp.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam String title, @RequestParam Integer count){

        return new ResponseEntity<>(quizService.createQuiz(category,title, count), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<List<QuestionWrapper>> getByQuizId(@PathVariable Integer id){

        return new ResponseEntity<>(quizService.getQuizById(id),HttpStatus.OK);

    }

    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> submitResponse(@PathVariable Integer id, @RequestBody List<UserResponse> responses){

        return new ResponseEntity<>(quizService.calculateScore(id, responses), HttpStatus.OK);
    }

}
