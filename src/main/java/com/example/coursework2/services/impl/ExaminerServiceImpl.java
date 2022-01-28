package com.example.coursework2.services.impl;

import com.example.coursework2.data.Question;
import com.example.coursework2.exceptions.TooManyQuestions;
import com.example.coursework2.services.ExaminerService;
import com.example.coursework2.services.QuestionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class ExaminerServiceImpl implements ExaminerService {


    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (questionService.size() < amount) {
            throw new TooManyQuestions();
        }
        Collection<Question> list = new ArrayList<>();
        for (int i = 0; i < questionService.size(); i++) {
            list.add(questionService.getRandomQuestion());
        }
        return list;
    }
}
