package com.example.coursework2.controller;


import com.example.coursework2.data.Question;
import com.example.coursework2.services.ExaminerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
@RequestMapping("/exam/java/generate")
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("")
    public Collection<Question> generate(@RequestParam int amount) {
        return examinerService.getQuestions(amount);
    }


}
