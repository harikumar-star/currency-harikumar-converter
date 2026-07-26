package com.quiz.controller;

import com.quiz.model.AnswerRequest;
import com.quiz.model.Question;
import com.quiz.model.Result;
import com.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class QuizController {

    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/questions")
    public List<Question> getQuestion()  {
        return quizService.getQuestions();
    }

    @PostMapping("/submit")
    public Result submitAnswer(@RequestBody AnswerRequest answerRequest){
        return quizService.calculateScore(answerRequest.getAnswers());
    }

}
