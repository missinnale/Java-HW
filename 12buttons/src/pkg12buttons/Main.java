/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg12buttons;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Math.random;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Finoadmin
 */
public class Main {
    public static int numberOfButtons = 12;
    public static JButton[] buttonArray = new JButton[numberOfButtons];
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(600, 600);
        frame.setVisible(true);
        frame.add(panel);
        panel.setLayout(new GridLayout(3,4));
        Random rand = new Random();
        for (int i = 0; i < numberOfButtons; ++i){
            buttonArray[i] = new JButton("Click me");
            buttonArray[i].addActionListener(new ButtonPress());
            buttonArray[i].setBackground(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
            buttonArray[i].setOpaque(true);
            buttonArray[i].setBorderPainted(false);
            panel.add(buttonArray[i]);
        }
    }
    
}

class ButtonPress implements ActionListener {    
    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton[] buttonArray = Main.buttonArray;
        Random rand = new Random();
        for(int i = 0; i < Main.numberOfButtons; ++i){
            if(buttonArray[i] == ae.getSource()){continue;}
            buttonArray[i].setBackground(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
        }
    }
}
