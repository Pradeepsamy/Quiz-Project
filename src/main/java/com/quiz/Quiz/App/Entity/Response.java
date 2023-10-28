package com.quiz.Quiz.App.Entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Response {

    private int qno;
    private String response;
}
