package org.example.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExController {

    @ExceptionHandler(NoHandlerFoundException.class)
    public String error404() {
        return "404error";
    }
}
