package com.Project.QuizApp.Service;

import com.Project.QuizApp.Model.Question;
import com.Project.QuizApp.Model.QuestionWrapper;
import com.Project.QuizApp.Model.Quiz;
import com.Project.QuizApp.Model.UserResponse;
import com.Project.QuizApp.Repo.QuestionDao;
import com.Project.QuizApp.Repo.QuizDao;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizService {

    @Autowired
    QuestionDao questionDao;

    @Autowired
    QuizDao quizDao;

    @Autowired
    ModelMapper modelMapper;


    public String createQuiz(String category, String title, Integer count) {

        List<Question> questionList =  questionDao.getQuestionsByCategoryAndCount(category,count);

        Quiz quiz = new Quiz();

        quiz.setTitle(title);

        quiz.setQuestion(questionList);

        quizDao.save(quiz);

        return "Success";


    }

    public List<QuestionWrapper> getQuizById(Integer id) {

        Optional<Quiz> quiz  = quizDao.findById(id);

        List<Question> questionList = quiz.get().getQuestion();

        return questionList.stream()
                .map(question -> modelMapper.map(question, QuestionWrapper.class))
                .collect(Collectors.toList());


    }

    public Integer calculateScore(Integer id, List<UserResponse> responses) {

        Quiz quiz  = quizDao.findById(id).get();

        List<Question> question = quiz.getQuestion();
        int i = 0;
        int right =0;
        for(UserResponse res : responses){

            if(res.getResponse().equals(question.get(i).getRightAnswer())){

             right++;


            }
            i++;
        }

      return right;
    }
}
