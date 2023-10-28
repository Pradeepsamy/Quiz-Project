package com.quiz.Quiz.App.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionWrapper {
    private int qno;
    private String qtitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
}
