/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Kathe
 */
public class PnButtons extends JPanel{
  
    private MainScreen mainScreen;
    private final String[] arrayTextButtons = { "9", "8", "7", "*",
                                                "4", "5", "6", "/",
                                                "1", "2", "3", "+",
                                                "0", "<<", "=", "-"};
    
    // <editor-fold desc="Builders">
    
    public PnButtons(){
        inicialize();
    }
    
    // </editor-fold>
    
    // <editor-fold desc="Methods">
    
    private void inicialize(){
        setLayout(new GridLayout(4, 4, 5, 5));
        createButtons();
    }

    private void createButtons(){
        for(int i = 0; i < arrayTextButtons.length; i++){
            add(new JButton(arrayTextButtons[i]));
        }
    }
    
    private void ModifyExpression(String expression){
        if(expression != "<<" ||expression != "=")
            mainScreen.pnScreen.setExpression(mainScreen.pnScreen.getText() + expression);
    }
    
    // </editor-fold>
    
}
