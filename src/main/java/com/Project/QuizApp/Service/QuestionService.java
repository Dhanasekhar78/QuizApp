package com.Project.QuizApp.Service;

import com.Project.QuizApp.Exception.GlobalExceptionHandler;
import com.Project.QuizApp.Exception.MyException;
import com.Project.QuizApp.Model.Question;
import com.Project.QuizApp.Repo.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions() {



        List<Question>  questions= questionDao.findAll();

        if (questions.isEmpty()) {
            throw new MyException("No questions found");
        }


            return new ResponseEntity<>(questions, HttpStatus.OK);


    }

    public ResponseEntity<List<Question>> getById(String category) {

        List<Question>  questions= questionDao.findByCategory(category);

        if (questions.isEmpty()) {
            throw new MyException("No questions found for category: " + category);
        }


        return  new ResponseEntity<>(questions,
                HttpStatus.OK);

    }

    public ResponseEntity<String>addQuestion(Question question){

      questionDao.save(question);

      return  new ResponseEntity<>("success",HttpStatus.OK);


    }
}
