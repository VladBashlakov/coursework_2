package com.example.coursework2;

import com.example.coursework2.data.Question;
import com.example.coursework2.exceptions.TooManyQuestions;
import com.example.coursework2.services.impl.ExaminerServiceImpl;
import com.example.coursework2.services.impl.JavaQuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import static com.example.coursework2.constants.Constants.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(MockitoExtension.class)

public class ExaminerServiceImplTest {
    private ExaminerServiceImpl out;

    @Mock
    private JavaQuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl getOut;

    @BeforeEach
    public void setUp() {
        out = new ExaminerServiceImpl(questionService);
    }

    @Test
    void testExceptionIfTooManyQuestions() {
        assertThrows(TooManyQuestions.class, () -> out.getQuestions(QUESTIONS.size() + 1));
    }

    @Test
    public void getQuestionsTest() {
        ArrayList<Question> act = new ArrayList<>(out.getQuestions(0));
        ArrayList<Question> exp = new ArrayList<>(QUESTIONS);
        assertTrue(act.size() == exp.size() && act.containsAll(exp) && exp.containsAll(act));
    }

}
