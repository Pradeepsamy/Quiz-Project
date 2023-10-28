package com.quiz.Quiz.App.Controller;

import com.quiz.Quiz.App.Entity.QuestionWrapper;
import com.quiz.Quiz.App.Entity.Response;
import com.quiz.Quiz.App.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String>createQuiz(@RequestParam String title,@RequestParam String category){
        return quizService.createQuiz(title,category);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>>getQuizQuestion(@PathVariable int id){
      return quizService.getQuizQuestion(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer>submitQuiz(@PathVariable int id,@RequestBody List<Response> response){
        return quizService.submit(id, response);
    }
}
