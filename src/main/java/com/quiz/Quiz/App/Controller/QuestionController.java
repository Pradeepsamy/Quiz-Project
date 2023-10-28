package com.quiz.Quiz.App.Controller;

import com.quiz.Quiz.App.Entity.Question;
import com.quiz.Quiz.App.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @PostMapping("add")
    public ResponseEntity<Question>saveQuestion(@RequestBody Question question){
        return questionService.SaveQuestion(question);
    }

    @DeleteMapping("delete/{qno}")
    public String deleteQuestion(@PathVariable int qno){
        questionService.deleteQuestion(qno);
        return "Data Deleted";
    }

    @GetMapping("allQuestion")
    public ResponseEntity<List<Question>>getAllQuestion(){
        return questionService.getAllQuestion();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>>findByCategory(@PathVariable String category){
        return questionService.findBycategory(category);
    }

}
