package com.rpn;

import java.util.Stack;

public class ReversePolishNotation {

  public static void main(String[] args) {
    String[] tokens = new String[] { "2", "1", "+", "3", "*" };
    System.out.println(evaluateReversePolishNotation(tokens));
  }

  public static int evaluateReversePolishNotation(String[] tokens) {
    Stack<Integer> evaluation = new Stack<>();

    for (String token : tokens) {
      if (isOperator(token)) {
        int rightOperand = evaluation.pop();
        int leftOperand = evaluation.pop();
        int result = performOperation(token, leftOperand, rightOperand);
        evaluation.push(result);
      } else {
        int operand = Integer.parseInt(token);
        evaluation.push(operand);
      }
    }

    return evaluation.pop();
  }

  public static int performOperation(String operator, int leftOperand, int rightOperand) {
    switch (operator) {
      case "+":
        return leftOperand + rightOperand;
      case "-":
        return leftOperand - rightOperand;
      case "*":
        return leftOperand * rightOperand;
      case "/":
        if (rightOperand == 0) {
          throw new ArithmeticException("Division by zero");
        }
        return leftOperand / rightOperand;
      default:
        throw new IllegalArgumentException("Invalid operator " + operator);
    }
  }

  public static boolean isOperator(String token) {
    return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
  }

}
