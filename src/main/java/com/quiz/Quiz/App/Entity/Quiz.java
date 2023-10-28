package com.quiz.Quiz.App.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "quiz")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@NonNull
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;


    @ManyToMany(cascade = CascadeType.ALL)
    private List<Question>questions;

}
