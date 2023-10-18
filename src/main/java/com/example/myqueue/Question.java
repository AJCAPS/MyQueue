package com.example.myqueue;

import java.util.List;

class Question {
    String questionText;
    List<String> choices;
    int correctAnswerIndex;

    public Question(String questionText, List<String> choices, int correctAnswerIndex) {
        this.questionText = questionText;
        this.choices = choices;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getChoices() {
        return choices;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    public void setChoices(List<String> choices) {
        this.choices = choices;
    }

    public void setCorrectAnswerIndex(int correctAnswerIndex) {
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }
}

