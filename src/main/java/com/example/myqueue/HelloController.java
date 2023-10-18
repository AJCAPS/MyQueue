package com.example.myqueue;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class HelloController {

    @FXML
    private Button AddQuestion;
    @FXML
    private Text alertText;

    @FXML
    private Button Choice1;

    @FXML
    private Button Choice2;

    @FXML
    private Button Choice3;

    @FXML
    private Button Choice4;

    @FXML
    private Button nextButton;

    @FXML
    private TextArea QuestionBox;

    @FXML
    private Label welcomeText;
    private MyQueue<Question> questionsQueue;

    public void setQuestionsQueue(MyQueue<Question> queue) {
        this.questionsQueue = queue;
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        try {
            // Load the FXML file for the popup window
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("questions.fxml"));
            Parent root = (Parent) fxmlLoader.load();

            Questions questionsController = fxmlLoader.getController();
            questionsController.setQuestionsQueue(questionsQueue);


            // Create a new stage for the popup
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL); // Set the window to be modal (blocks other windows until this one is closed)
            stage.setTitle("Popup Window");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void moveToNextQuestion(){
        QuestionBox.clear();
        if (questionsQueue.empty()){
            alertText.setText("Queue is empty.");
            return;
        }
        if (!Objects.equals(QuestionBox.getText(), "")) {
            questionsQueue.push(questionsQueue.front());
            questionsQueue.pop();
            alertText.setText("Moved to First Question.");
        }

        String tempQuestion = questionsQueue.front().getQuestionText();
        String tempChoice1 = questionsQueue.front().choices.get(0);
        String tempChoice2 = questionsQueue.front().choices.get(1);
        String tempChoice3 = questionsQueue.front().choices.get(2);
        String tempChoice4 = questionsQueue.front().choices.get(3);

        QuestionBox.appendText(tempQuestion);
        Choice1.setText(tempChoice1);
        Choice2.setText(tempChoice2);
        Choice3.setText(tempChoice3);
        Choice4.setText(tempChoice4);
       }
    @FXML
    private void pickChoice1(){
        if(questionsQueue.front().choices.indexOf(Choice1.getText())==questionsQueue.front().correctAnswerIndex){
            questionsQueue.pop();
            alertText.setText("Answer Correct!");
            moveToNextQuestion();
        } else {
            questionsQueue.push(questionsQueue.front());
            questionsQueue.pop();
            alertText.setText("Wrong Answer!");
            moveToNextQuestion();
        }
    }
    @FXML
    private void pickChoice2(){
        if(questionsQueue.front().choices.indexOf(Choice2.getText())==questionsQueue.front().correctAnswerIndex){
            questionsQueue.pop();
            alertText.setText("Answer Correct!");
            moveToNextQuestion();
        } else {
            questionsQueue.push(questionsQueue.front());
            questionsQueue.pop();
            alertText.setText("Wrong Answer!");
            moveToNextQuestion();
        }
    }
    @FXML
    private void pickChoice3(){
        if(questionsQueue.front().choices.indexOf(Choice3.getText())==questionsQueue.front().correctAnswerIndex){
            questionsQueue.pop();
            alertText.setText("Answer Correct!");
            moveToNextQuestion();
        } else {
            questionsQueue.push(questionsQueue.front());
            questionsQueue.pop();
            alertText.setText("Wrong Answer!");
            moveToNextQuestion();
        }
    }
    @FXML
    private void pickChoice4(){
        if(questionsQueue.front().choices.indexOf(Choice4.getText())==questionsQueue.front().correctAnswerIndex){
            questionsQueue.pop();
            alertText.setText("Answer Correct!");
            moveToNextQuestion();
        } else {
            questionsQueue.push(questionsQueue.front());
            questionsQueue.pop();
            alertText.setText("Wrong Answer!");
            moveToNextQuestion();
        }
    }


}
