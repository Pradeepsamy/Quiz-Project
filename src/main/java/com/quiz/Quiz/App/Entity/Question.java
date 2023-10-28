package com.quiz.Quiz.App.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "quizquestion")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer qno;
    private String qtitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String category;
    private String answer;
    private int difficulty;

}
