package com.example.coursework2.services.impl;

import com.example.coursework2.data.Question;
import com.example.coursework2.services.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questionSet;

    public JavaQuestionService() {
        this.questionSet = new HashSet<>();
    }

    @Override
    public Question add(String question, String answer) {
        questionSet.add(new Question(question, answer));
        return new Question(question, answer);
    }

    @Override
    public Question add(Question question) {
        questionSet.add(question);
        return question;
    }

    @Override
    public Question remove(String question, String answer) {
        return remove(new Question(question, answer));
    }

    @Override
    public Question remove(Question question) {
        questionSet.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questionSet;
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        ArrayList<Question> storage = new ArrayList<>(questionSet);
        int index = random.nextInt(storage.size());
        return storage.get(index);
    }

    @Override
    public int size() {
        return questionSet.size();
    }

}
