package com.quiz.Quiz.App.Service;

import com.quiz.Quiz.App.Dao.QuestionDao;
import com.quiz.Quiz.App.Entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<Question>SaveQuestion(Question question){
        return new ResponseEntity<>(questionDao.save(question), HttpStatus.CREATED);
    }

    public void deleteQuestion(int qno) {
        questionDao.deleteById(qno);
    }

    public ResponseEntity<List<Question>>getAllQuestion(){
        return new ResponseEntity<>(questionDao.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<List<Question>>findBycategory(String category){
        return new ResponseEntity<>(questionDao.findRandomQuestion(category),HttpStatus.OK);
    }
}
