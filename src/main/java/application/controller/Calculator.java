package application.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Calculator {

    Float data = 0f;
    int operation = -1;

    @FXML
    private Label display;

    @FXML
    private Button clear;

    @FXML
    private Button percent;

    @FXML
    private Button plusMinus;

    @FXML
    private Button multiply;

    @FXML
    private Button divide;

    @FXML
    private Button plus;

    @FXML
    private Button minus;

    @FXML
    private Button equals;

    @FXML
    private Button dot;

    @FXML
    private Button zero;

    @FXML
    private Button one;

    @FXML
    private Button two;

    @FXML
    private Button three;

    @FXML
    private Button four;

    @FXML
    private Button five;

    @FXML
    private Button six;

    @FXML
    private Button seven;

    @FXML
    private Button eight;

    @FXML
    private Button nine;


    @FXML
    void handleButtonAction(ActionEvent event) {
        if (event.getSource() == one) {
            display.setText(display.getText() + "1");
        } else if (event.getSource() == two) {
            display.setText(display.getText() + "2");
        } else if (event.getSource() == three) {
            display.setText(display.getText() + "3");
        } else if (event.getSource() == four) {
            display.setText(display.getText() + "4");
        } else if (event.getSource() == five) {
            display.setText(display.getText() + "5");
        } else if (event.getSource() == six) {
            display.setText(display.getText() + "6");
        } else if (event.getSource() == seven) {
            display.setText(display.getText() + "7");
        } else if (event.getSource() == eight) {
            display.setText(display.getText() + "8");
        } else if (event.getSource() == nine) {
            display.setText(display.getText() + "9");
        } else if (event.getSource() == zero) {
            display.setText(display.getText() + "0");
        } else if (event.getSource() == clear) {
            display.setText("");
        } else if (event.getSource() == plus) {
            data = Float.parseFloat(display.getText());
            operation = 1; //Addition
            display.setText("");
        } else if (event.getSource() == minus) {
            data = Float.parseFloat(display.getText());
            operation = 2; //Substraction
            display.setText("");
        } else if (event.getSource() == multiply) {
            data = Float.parseFloat(display.getText());
            operation = 3; //Multiply
            display.setText("");
        } else if (event.getSource() == divide) {
            data = Float.parseFloat(display.getText());
            operation = 4; //Division
            display.setText("");
        } else if(event.getSource() == plusMinus) {
            String text = display.getText();
            if (text.startsWith("-")) {
                display.setText(text.substring(1));
            } else if (!text.isEmpty()) {
                display.setText("-" + text);
            }
        } else if (event.getSource() == percent) {
            try {
                float number = Float.parseFloat(display.getText());
                number = number / 100f;
                display.setText(String.valueOf(number));
            } catch (Exception ignored) {}
        } else if (event.getSource() == dot) {
            String text = display.getText();
            if (!text.contains(".")) {
                if (text.isEmpty()) {
                    display.setText("0.");
                } else {
                    display.setText(text + ".");
                }
            }
        } else if (event.getSource() == equals) {
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
}
