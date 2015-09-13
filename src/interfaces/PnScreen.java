/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author SIP315
 */
public class PnScreen extends JPanel {

    public JTextArea textArea;

    public PnScreen() {
        inicialize();
    }

    private void inicialize() {
        setLayout(new GridLayout(1, 1, 5, 5));

        textArea = new JTextArea(3, 30);
        textArea.setBorder(BorderFactory.createEtchedBorder(0));
        textArea.setFont(new Font("SansSerif", 1, 16));
        textArea.setSelectionColor(Color.white);
        textArea.setEditable(false);

        add(textArea);
    }

    public void setExpression(String expression) {
        textArea.setText(expression);
    }

    public String getText() {
        return textArea.getText();
    }

}
