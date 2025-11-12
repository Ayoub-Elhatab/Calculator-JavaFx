package application.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Calculator {

    private float data = 0f;
    private Operation currentOperation;

    @FXML private Label display;

    enum Operation { ADD, SUB, MUL, DIV }

    @FXML
    void onDigit(ActionEvent event) {
        Button btn = (Button) event.getSource();
        display.setText(display.getText() + btn.getText());
    }

    @FXML
    void onDot(ActionEvent event) {
        if (!display.getText().contains(".")) {
            display.setText(display.getText().isEmpty() ? "0." : display.getText() + ".");
        }
    }

    @FXML
    void onPercent(ActionEvent event) {
        try {
            float number = Float.parseFloat(display.getText());
            display.setText(String.valueOf(number / 100f));
        } catch (Exception ignored) {}
    }

    @FXML
    void onPlusMinus(ActionEvent event) {
        String text = display.getText();
        if (text.startsWith("-")) display.setText(text.substring(1));
        else if (!text.isEmpty()) display.setText("-" + text);
    }

    @FXML
    void onOperation(ActionEvent event) {
        Button btn = (Button) event.getSource();
        data = Float.parseFloat(display.getText());

        switch (btn.getText()) {
            case "+" -> currentOperation = Operation.ADD;
            case "-" -> currentOperation = Operation.SUB;
            case "×" -> currentOperation = Operation.MUL;
            case "÷" -> currentOperation = Operation.DIV;
        }

        display.setText("");
    }

    @FXML
    void onEquals(ActionEvent event) {
        float second = Float.parseFloat(display.getText());
        float result = switch (currentOperation) {
            case ADD -> data + second;
            case SUB -> data - second;
            case MUL -> data * second;
            case DIV -> data / second;
        };
        display.setText(String.valueOf(result));
    }

    @FXML
    void onClear(ActionEvent event) {
        display.setText("");
        data = 0f;
        currentOperation = null;
    }
}

