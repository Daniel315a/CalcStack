/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Daniel
 */
public class MainScreen extends JFrame implements ActionListener{

    public PnButtons pnButtons;
    public PnScreen pnScreen;
    
    public MainScreen(){
        //setLayout(new );
        getContentPane().add(new PnScreen(), "First");
        getContentPane().add(new PnButtons(), "Center");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
