package com.rpn;

import java.util.Stack;

public class ReversePolishNotation {

  public static void main(String[] arg) {
    String[] tokens = new String[] { "2", "1", "+", "3", "*" };
    System.out.println(evaluateReversePolishNotation(tokens));
  }

  public static int evaluateReversePolishNotation(String[] tokens) {
    Stack<Integer> evaluation = new Stack<>();

    int leftOperand = 0;
    int rightOperand = 0;
    for (String token : tokens) {
      switch (token) {
        case "+":
          evaluation.push(evaluation.pop() + evaluation.pop());
          break;
        case "-":
          rightOperand = evaluation.pop();
          leftOperand = evaluation.pop();
          evaluation.push(leftOperand - rightOperand);
          break;
        case "*":
          evaluation.push(evaluation.pop() * evaluation.pop());
          break;
        case "/":
          rightOperand = evaluation.pop();
          leftOperand = evaluation.pop();
          evaluation.push(leftOperand / rightOperand);
          break;
        default:
          evaluation.push(Integer.parseInt(token));
          break;
      }
    }

    return evaluation.pop();
  }

  public static boolean isNumber(String str) {
    try {
      Double.parseDouble(str);
      return true;
    } catch (NumberFormatException ex) {
      return false;
    }
  }

}
