package com.Project.QuizApp.Repo;


import com.Project.QuizApp.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao  extends JpaRepository<Question,Integer> {

    List<Question> findByCategory(String category);

    @Query(value = "SELECT * FROM question q where q.category=:category limit :count",nativeQuery = true)
    List<Question> getQuestionsByCategoryAndCount(String category, Integer count);
}
