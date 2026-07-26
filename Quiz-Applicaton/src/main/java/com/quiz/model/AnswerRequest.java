package com.quiz.model;

import java.util.Map;

public class AnswerRequest {

    Map<Integer,Integer> answers;

    public Map<Integer, Integer> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<Integer, Integer> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "AnswerRequest{" +
                "answers=" + answers +
                '}';
    }
}
