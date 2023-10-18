package com.example.myqueue;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Arrays;
import java.util.List;

public class Questions {

    @FXML
    private TextField Choice1;

    @FXML
    private TextField Choice2;
    @FXML
    private Button AddQbutton;
    @FXML
    private TextField Choice3;

    @FXML
    private TextField Choice4;

    @FXML
    private ChoiceBox<String> CorrectChoice; // Let's define it to hold String values

    @FXML
    private TextArea Question;

    private MyQueue<Question> questionsQueue;

    public void setQuestionsQueue(MyQueue<Question> queue) {
        this.questionsQueue = queue;
    }

    public void initialize() {
        // Initialize the ChoiceBox with choices
        CorrectChoice.getItems().addAll("Choice1", "Choice2", "Choice3", "Choice4");
    }

    @FXML
    private void handleSaveQuestion() {
        String questionText = Question.getText();
        List<String> choices = Arrays.asList(
                Choice1.getText(),
                Choice2.getText(),
                Choice3.getText(),
                Choice4.getText()
        );

        int correctChoiceIndex = CorrectChoice.getSelectionModel().getSelectedIndex();

        if (correctChoiceIndex == -1) {
            showAlert("Error", "Please select a correct choice.");
            return;
        }

        Question newQuestion = new Question(questionText, choices, correctChoiceIndex);
        questionsQueue.push(newQuestion);

        clearFields();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearFields() {
        Question.clear();
        Choice1.clear();
        Choice2.clear();
        Choice3.clear();
        Choice4.clear();
        CorrectChoice.getSelectionModel().clearSelection();
    }
}
