package com.quiz.Quiz.App.Service;

import com.quiz.Quiz.App.Dao.QuestionDao;
import com.quiz.Quiz.App.Dao.QuizDao;
import com.quiz.Quiz.App.Entity.Question;
import com.quiz.Quiz.App.Entity.QuestionWrapper;
import com.quiz.Quiz.App.Entity.Quiz;
import com.quiz.Quiz.App.Entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {


    Quiz quiz;

    List<Quiz>quizzes;

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<String> createQuiz(String title, String category) {
        if (quiz==null){
            quiz=new Quiz();
        }
        List<Question> questions=questionDao.findRandomQuestion(category);
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("Success",HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(int id) {
       Optional<Quiz> quizQuestion= quizDao.findById(id);
       List<Question>QuestionfromDb=quizQuestion.get().getQuestions();
       List<QuestionWrapper>QuestionforUser=new ArrayList<>();
       for(Question q:QuestionfromDb){
           QuestionWrapper questionWrapper=new QuestionWrapper(q.getQno(), q.getQtitle(),q.getOption1(),q.getOption2(), q.getOption3(), q.getOption4());
           QuestionforUser.add(questionWrapper);
       }
       return new ResponseEntity<>(QuestionforUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> submit(int id, List<Response> response) {
        Quiz quiz1 =quizDao.findById(id).get();
        List<Question> questions = quiz1.getQuestions();
        int i=0;
        int right=0;
        for(Response r:response){
            if(r.getResponse().equals(questions.get(i).getAnswer()))
                right++;

            i++;
        }
        return new ResponseEntity<>(right,HttpStatus.OK);
    }
}
