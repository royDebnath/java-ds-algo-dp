package com.theory.support;

public class Knowledge {
    private static final Integer ANSWER = 42;
    public String askQuestion(String question) {
        return "The answer to '" + question + "' is: " + ANSWER;
    }
}