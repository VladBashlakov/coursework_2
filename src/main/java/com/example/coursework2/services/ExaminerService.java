package com.example.coursework2.services;

import com.example.coursework2.data.Question;

import java.util.Collection;

public interface ExaminerService {

   Collection <Question> getQuestions(int amount);

}
