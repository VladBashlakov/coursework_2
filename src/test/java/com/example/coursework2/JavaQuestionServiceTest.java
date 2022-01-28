package com.example.coursework2;

import com.example.coursework2.data.Question;
import com.example.coursework2.exceptions.TooManyQuestions;
import com.example.coursework2.services.QuestionService;
import com.example.coursework2.services.impl.JavaQuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashSet;

import static com.example.coursework2.constants.Constants.*;
import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionServiceTest {

    private final QuestionService out = new JavaQuestionService();

    Question question1;
    Question question2;
    Question question3;
    Question question4;
    Question question5;

    @BeforeEach
    public void setUp() {

        question1 = new Question(QUESTION1, ANSWER1);
        question2 = new Question(QUESTION2, ANSWER2);
        question3 = new Question(QUESTION3, ANSWER3);
        question4 = new Question(QUESTION4, ANSWER4);
        question5 = new Question(QUESTION5, ANSWER5);

        out.add(question1);
        out.add(question2);
        out.add(question3);
        out.add(question4);
        out.add(new Question(QUESTION5, ANSWER5));

    }

    @Test
    public void testAddMethod() {
        Collection<Question> exp = new HashSet<>(out.getAll());
        Collection<Question> act = new HashSet<>();

        act.add(question1);
        act.add(question2);
        act.add(question3);
        act.add(question4);
        act.add(new Question(QUESTION5, ANSWER5));

        assertTrue(act.size() == exp.size() && act.containsAll(exp) && exp.containsAll(act));
        assertEquals(question1, out.add(QUESTION1, ANSWER1));
    }

    @Test
    public void testRemoveMethod() {
        Collection<Question> exp = new HashSet<>(out.getAll());
        exp.remove(question1);
        Collection<Question> act = new HashSet<>();

        act.add(question1);
        act.add(question2);
        act.add(question3);
        act.add(question4);
        act.add(new Question(QUESTION5, ANSWER5));

        act.remove(question1);
        assertTrue(act.size() == exp.size() && act.containsAll(exp) && exp.containsAll(act));

    }

    @Test
    public void testGetRandomQuestion() {
        assertNotNull(out.getRandomQuestion());
        assertInstanceOf(Question.class,out.getRandomQuestion());
    }



}
