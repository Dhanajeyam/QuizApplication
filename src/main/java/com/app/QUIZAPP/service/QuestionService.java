package com.app.QUIZAPP.service;

import com.app.QUIZAPP.model.Question;
import com.app.QUIZAPP.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<List<Question>> getAllQuestions() {

        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }


    public ResponseEntity<List<Question>> getQuestionByCategory(String category) {

        try {
            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);

        }catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> addQuestion(Question question) {
        questionDao.save(question);
        try {
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);

    }


    public String addMultipleQuestions(List<Question> questions) {
        if (questions == null || questions.isEmpty()) {
            return "No questions to add";
        }
        questionDao.saveAll(questions); // Save all the questions in one call
        return "Successfully added " + questions.size() + " questions";
    }

    public String deleteQuestion(Integer id) {
        questionDao.deleteById(id);
        return "Successfully deleted";
    }
}
