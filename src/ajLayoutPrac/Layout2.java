/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajLayoutPrac;

import java.awt.Button;
import java.awt.Color;
import java.awt.HeadlessException;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Zakakaria
 */
public class Layout2 extends JFrame{

    public Layout2() {
        
    }
    
    
    public static void main(String[] args) {
        Layout2 l2=new Layout2();
        int h=l2.getSize().height;
        System.out.println("h"+h);
        JPanel top=new JPanel();
        top.setBackground(Color.GREEN);
        top.setLayout(new BoxLayout(top, BoxLayout.Y_AXIS));
        top.add(Box.createVerticalGlue());
        //top.setSize(100,100);
        //int h=top.getSize().height;
        //System.out.println("h"+h);
        
        JPanel bottom=new JPanel();
        //bottom.setSize(100,100);
        bottom.setBackground(Color.ORANGE);
        bottom.setAlignmentX(1f);
        bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
        Button b1=new Button("B1");
        Button b2=new Button("B2");
        
        bottom.add(b1);
        bottom.add(b2);
        l2.add(top);
        int th=bottom.getSize().height;
        top.add(bottom);
        System.out.println("th"+th);
        
        l2.setTitle("Two Buttons");
        l2.setSize(600, 550);
        l2.setVisible(true);
        l2.setDefaultCloseOperation(EXIT_ON_CLOSE);
        l2.setLocationRelativeTo(null);
    }
}
