package application.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Calculator {

    Float data = 0f;
    int operation = -1;

    @FXML private Label display;
    @FXML private Button clear, percent, plusMinus, multiply, divide, plus, minus, equals, dot;
    @FXML private Button zero, one, two, three, four, five, six, seven, eight, nine;

    @FXML
    void handleButtonAction(ActionEvent event) {
        Object src = event.getSource();

        if (isNumberButton(src)) {
            appendNumber(getButtonValue(src));
        }else if (src == clear) {
            clearDisplay();
        }else if (isOperationButton(src)) {
            prepareOperation(src);
        }else if (src == plusMinus) {
            toggleSign();
        }else if (src == percent) {
            applyPercent();
        }else if (src == dot) {
            appendDot();
        }else if (src == equals) {
            calculateResult();
        }
    }

    private boolean isNumberButton(Object src) {
        return src == zero || src == one || src == two || src == three || src == four ||
                src == five || src == six || src == seven || src == eight || src == nine;
    }

    private boolean isOperationButton(Object src) {
        return src == plus || src == minus || src == multiply || src == divide;
    }

    private String getButtonValue(Object src) {
        if (src == zero) return "0";
        if (src == one) return "1";
        if (src == two) return "2";
        if (src == three) return "3";
        if (src == four) return "4";
        if (src == five) return "5";
        if (src == six) return "6";
        if (src == seven) return "7";
        if (src == eight) return "8";
        return "9";
    }

    private void appendNumber(String number) {
        display.setText(display.getText() + number);
    }

    private void clearDisplay() {
        display.setText("");
    }

    private void appendDot() {
        String text = display.getText();
        if (!text.contains(".")) {
            display.setText(text.isEmpty() ? "0." : text + ".");
        }
    }

    private void toggleSign() {
        String text = display.getText();
        if (text.startsWith("-")) display.setText(text.substring(1));
        else if (!text.isEmpty()) display.setText("-" + text);
    }

    private void applyPercent() {
        try {
            float number = Float.parseFloat(display.getText());
            display.setText(String.valueOf(number / 100f));
        } catch (Exception ignored) {}
    }

    private void prepareOperation(Object src) {
        data = Float.parseFloat(display.getText());

        if (src == plus) operation = 1;
        else if (src == minus) operation = 2;
        else if (src == multiply) operation = 3;
        else if (src == divide) operation = 4;

        display.setText("");
    }

    private void calculateResult() {
        Float secondOperand = Float.parseFloat(display.getText());
        Float answer = 0f;

        switch (operation) {
            case 1: answer = data + secondOperand; break;
            case 2: answer = data - secondOperand; break;
            case 3: answer = data * secondOperand; break;
            case 4:
                try {
                    answer = data / secondOperand;
                } catch (Exception e) {
                    display.setText("Error");
                    return;
                }
                break;
        }

        display.setText(String.valueOf(answer));
    }
}
