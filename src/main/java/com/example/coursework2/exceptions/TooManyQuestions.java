package com.example.coursework2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)

public class TooManyQuestions extends RuntimeException {
    private static final String DEFAULT_MESSAGE = "запрошено большее количество вопросов, чем хранится в сервисе";

    public TooManyQuestions() {
        super(DEFAULT_MESSAGE);
    }
}
