/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calc;

import stack.ArrayStack;
import comun.Utilities;

/**
 *
 * @author Daniel
 */
public class ExpressionFormat {

    private static ArrayStack<String> inputStack;
    private static ArrayStack<String> stackOperators;
    private static ArrayStack<String> outputStack;

    // <editor-fold desc="Builders">
    
    static {
        inputStack = new ArrayStack<>();
        stackOperators = new ArrayStack<>();
        outputStack = new ArrayStack<>();
    }

    // </editor-fold>
    
    // <editor-fold desc="Methods Converting to post-order">
    
    public static String convert(String expression) {
        inputStack = Utilities.fillInputStack(debugExpresion(expression).split(" "));
        convertPostToInOrder();
        return outputStack.toString();
    }

    private static void convertPostToInOrder() {
        while (!inputStack.isEmpty()) {
            switch (hierarchyOfOperators(inputStack.peek())) {
                case 1:
                    stackOperators.push(inputStack.pop());
                    break;
                case 3:
                case 4:
                    while (hierarchyOfOperators(stackOperators.peek()) >= hierarchyOfOperators(inputStack.peek())) {
                        outputStack.push(stackOperators.pop());
                    }
                    stackOperators.push(inputStack.pop());
                    break;
                case 2:
                    while (!stackOperators.peek().equals("(")) {
                        outputStack.push(stackOperators.pop());
                    }
                    stackOperators.pop();
                    inputStack.pop();
                    break;
                default:
                    outputStack.push(inputStack.pop());
            }
        }
    }

    private static int hierarchyOfOperators(String operator) {
        int firstOperator = 99;
        if (operator.equals("^")) {
            firstOperator = 5;
        }
        if (operator.equals("*") || operator.equals("/")) {
            firstOperator = 4;
        }
        if (operator.equals("+") || operator.equals("-")) {
            firstOperator = 3;
        }
        if (operator.equals(")")) {
            firstOperator = 2;
        }
        if (operator.equals("(")) {
            firstOperator = 1;
        }
        return firstOperator;
    }

    private static String debugExpresion(String expression) {
        expression = expression.replaceAll("\\s+", "");
        expression = "(" + expression + ")";
        String simbols = "+-*/()";
        String result = "";

        for (int i = 0; i < expression.length(); i++) {
            if (simbols.contains("" + expression.charAt(i))) {
                result += " " + expression.charAt(i) + " ";
            } else {
                result += expression.charAt(i);
            }
        }
        return result.replaceAll("\\s+", " ").trim();
    }

    // </editor-fold>
    
}
