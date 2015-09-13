/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calc;

import java.util.ArrayList;
import stack.ArrayStack;
import comun.Utilities;

/**
 *
 * @author Daniel
 */
public class Calc {

    private static ArrayStack<String> inputStack;
    private static ArrayStack<String> outputStack;

    // <editor-fold desc="Builders">
    
    static{
        inputStack = new ArrayStack<>();
        outputStack = new ArrayStack<>();
    }
    
    // </editor-fold>
    
    // <editor-fold desc="Methods">
    
    public static String calculate(String expressionPostOrder){
        inputStack = Utilities.fillInputStack(expressionPostOrder.split(" "));
        evaluateExpression();
        return outputStack.toString(); 
    }
    
    private static void evaluateExpression() {
        String operators = "+-*/%";
        while (!inputStack.isEmpty()) {
            if (operators.contains("" + inputStack.peek())) {
                outputStack.push(getOperation(inputStack.pop(), outputStack.pop(), outputStack.pop()) + "");
            } else {
                outputStack.push(inputStack.pop());
            }
        }
    }

    private static double getOperation(String operator, String n2, String n1) {
        double numberOne = Double.parseDouble(n1);
        double nunberTwo = Double.parseDouble(n2);
        if (operator.equals("+")) {
            return (numberOne + nunberTwo);
        }
        if (operator.equals("-")) {
            return (numberOne - nunberTwo);
        }
        if (operator.equals("*")) {
            return (numberOne * nunberTwo);
        }
        if (operator.equals("/")) {
            return (numberOne / nunberTwo);
        }
        if (operator.equals("%")) {
            return (numberOne % nunberTwo);
        }
        return 0;
    }

    // </editor-fold>
}
