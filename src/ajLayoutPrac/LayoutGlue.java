/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajLayoutPrac;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.HeadlessException;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Zakakaria
 */
public class LayoutGlue extends JFrame{

    public LayoutGlue(){
        JPanel top=new JPanel();
        top.setLayout(new BoxLayout(top, BoxLayout.Y_AXIS));
        top.setBackground(Color.yellow);
        top.add(Box.createVerticalGlue());
        add(top);
        
        JPanel bottom=new JPanel();
        bottom.setBackground(Color.GREEN);
        bottom.setAlignmentX(1f);
        bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
        
        JButton b1=new JButton("B1");
        JButton b2=new JButton("B2");
        bottom.add(b1);
        bottom.add(Box.createRigidArea(new Dimension(5, 0)));
        bottom.add(b2);
        bottom.add(Box.createRigidArea(new Dimension(15, 0)));
        
        top.add(bottom);
        top.add(Box.createRigidArea(new Dimension(0, 15)));
        
        
        setTitle("Two JButtons");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);        
        
    }
    
    
    
    public static void main(String[] args) {
        new LayoutGlue();
    }
}
