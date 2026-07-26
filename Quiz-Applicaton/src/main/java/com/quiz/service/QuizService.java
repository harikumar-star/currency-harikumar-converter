package com.quiz.service;

import com.quiz.model.Question;
import com.quiz.model.Result;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class QuizService {

    private List<Question> questions = new ArrayList<>();

    @PostConstruct
    public void loadQuestions() throws IOException {
        List<String> lines = Files.readAllLines(Path.of("C:\\Projects\\Quiz-Applicaton\\src\\main\\resources\\quiz.txt"));
        int id = 1;

        for (String line : lines) {
            // 1. Skip blank lines
            if (line.trim().isEmpty()) continue;

            // 2. Skip the header line if it contains text instead of a number
            if (line.contains("Correct Index") || line.contains("Question")) continue;
            String[] data = line.split("\\|");
            Question q = new Question();
            q.setId(id++);
            q.setQuestion(data[0]);
            q.setOptions(List.of(data[1], data[2], data[3], data[4]));
            q.setCorrectAnswer(Integer.parseInt(data[5]));
            questions.add(q);
        }

    }

    public List<Question> getQuestions() {
        return questions;
    }

    public Result calculateScore(Map<Integer, Integer> userAnswers) {
        int score = 0;

        for (Question q : questions) {
            Integer answer = userAnswers.get(q.getId());

            if (answer != null && answer == q.getCorrectAnswer()) {
                score++;
            }
        }
        Result result = new Result();
        result.setTotalQuestions(questions.size());
        result.setCorrectAnswer(score);
        result.setScore(score);
        return result;

    }
}


