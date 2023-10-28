package com.quiz.Quiz.App.Dao;

import com.quiz.Quiz.App.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {


    List<Question> findByCategory(String category);

    @Query(value = "select * from quizquestion q where q.category=?1 order by rand() limit 4",nativeQuery = true)
    List<Question>findRandomQuestion(String category);
}
