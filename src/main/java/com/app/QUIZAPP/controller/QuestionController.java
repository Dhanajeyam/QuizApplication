package com.app.QUIZAPP.controller;

import com.app.QUIZAPP.model.Question;
import com.app.QUIZAPP.questionListRequest;
import com.app.QUIZAPP.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;
    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category) {
        return questionService.getQuestionByCategory(category);
    }
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {

        return questionService.addQuestion(question);
    }

    @PostMapping("addMultiple")
    public String addMultipleQuestions(@RequestBody questionListRequest request) {
        return questionService.addMultipleQuestions(request.getQuestions());
    }

    @DeleteMapping("delete/{id}")
    public String deleteQuestion(@PathVariable Integer id){
        return questionService.deleteQuestion(id);
    }

}
