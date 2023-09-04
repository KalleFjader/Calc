package com.example.calc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Stack;

public class Controller extends Application {

    Stack<String> stack = new Stack<>();    //Stack of pressed digits
    Stack<Integer> digitStack = new Stack<>();      //Stack of combined digits
    Stack<String> symbolStack = new Stack<>();      //Stack of symbols

    @FXML
    private void btn1(ActionEvent event) {
        System.out.println("one");
        stack.push("1");
    }

    @FXML
    private void btn2(ActionEvent event) {
        System.out.println("two");
        stack.push("2");
    }

    @FXML
    private void btn3(ActionEvent event) {
        System.out.println("three");
        stack.push("3");
    }

    @FXML
    private void btn4(ActionEvent event) {
        System.out.println("four");
        stack.push("4");
    }

    @FXML
    private void btn5(ActionEvent event) {
        System.out.println("five");
        stack.push("5");
    }

    @FXML
    private void btn6(ActionEvent event) {
        System.out.println("six");
        stack.push("6");
    }

    @FXML
    private void btn7(ActionEvent event) {
        System.out.println("seven");
        stack.push("7");
    }

    @FXML
    private void btn8(ActionEvent event) {
        System.out.println("eight");
        stack.push("8");
    }

    @FXML
    private void btn9(ActionEvent event) {
        System.out.println("nine");
        stack.push("9");
    }

    @FXML
    private void btn0(ActionEvent event) {
        System.out.println("zero");
        stack.push("0");
    }

    @FXML
    private void btnplus(ActionEvent event) {
        System.out.println("plus");
        int intdigit = initializeNumbers();         //Initializes pressed numbers to one digit
        System.out.println("Number initialized: " + intdigit);
        digitStack.push(intdigit);      //Pushes digit to stack
        symbolStack.push("+");      //Pushes symbol to stack

    }

    @FXML
    private void btnminus(ActionEvent event) {
        System.out.println("minus");
        int intdigit = initializeNumbers();     //Initializes pressed numbers to one digit
        System.out.println("Number digit: " + intdigit);
        digitStack.push(intdigit);      //Pushes digit to stack
        symbolStack.push("-");      //Pushes symbol to stack
        System.out.println("Top of symbolStack =  " + symbolStack.peek());
        System.out.println("Top of digitStack =  " + digitStack.peek());
    }

    @FXML
    private void btnenter(ActionEvent event) {
        System.out.println("enter");

        if(!stack.isEmpty()){       //Checks if there are un-initialized numbers in the stack and initializes them
            int intdigit = initializeNumbers();
            System.out.println("Number initialized: " + intdigit);
            digitStack.push(intdigit);
        }

        int finalresult = digitStack.pop();        //Creates the final result

        while (!digitStack.isEmpty()){          //Checks for symbol to use and calculates final result
            if(symbolStack.peek() == "+"){
                symbolStack.pop();
                finalresult = finalresult + digitStack.pop();
            }
            else if(symbolStack.peek() == "-"){
                symbolStack.pop();
                finalresult = -finalresult + digitStack.pop();      //FIXA MINUS SYSTEMET!!!
            }
        }
        String finalResultString = String.valueOf(finalresult);
        resultBox.setText(finalResultString);
        System.out.println("result shown");
    }

    private int initializeNumbers(){        //Initializes pressed digits to one number
        System.out.println("initializeNumbers() called");

        String digit = "";
        while(!stack.isEmpty()){
            digit = stack.pop() + digit;
        }
        int intdigit = Integer.parseInt(digit);
        return intdigit;
    }

    @FXML
    Label resultBox;





}