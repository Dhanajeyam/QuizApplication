package com.app.QUIZAPP;

import com.app.QUIZAPP.model.Question;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class questionListRequest {
    // Getters and Setters
    private List<Question> questions;

}
