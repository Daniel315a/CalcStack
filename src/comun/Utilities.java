/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comun;

import stack.ArrayStack;

/**
 *
 * @author Daniel
 */
public class Utilities {
    
    public static ArrayStack<String> fillInputStack(String[] arrayExpression) {
        ArrayStack<String> inputStack = new ArrayStack();
        for (int i = arrayExpression.length - 1; i >= 0; i--) {
            inputStack.push(arrayExpression[i]);
        }
        return inputStack;
    }
    
}
