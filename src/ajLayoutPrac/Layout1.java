/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajLayoutPrac;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Zakakaria
 */
public class Layout1 extends JFrame{

    public Layout1() {
        
        JButton tb1=new JButton("TB1");
        JButton tb2=new JButton("TB2");
        JButton tb3=new JButton("TB3");
        
        JButton cb1=new JButton("CB1");
        JButton cb2=new JButton("CB2");
        JButton cb3=new JButton("CB3");
        
        JButton bb1=new JButton("BB1");
        JButton bb2=new JButton("BB2");
        JButton bb3=new JButton("BB3");
        JButton bb4=new JButton("BB4");
        JButton bb5=new JButton("BB5");
        JButton bb6=new JButton("BB6");
        
        JPanel topJp=new JPanel();
        topJp.setBackground(Color.YELLOW);
        topJp.setLayout(new FlowLayout());
        topJp.add(tb1);
        topJp.add(tb2);
        topJp.add(tb3);
        
        JPanel centerJp=new JPanel();
        centerJp.setBackground(Color.GREEN);
        centerJp.setLayout(new BoxLayout(centerJp, BoxLayout.Y_AXIS));
        centerJp.add(cb1);
        centerJp.add(cb2);
        centerJp.add(cb3);
        
        JPanel bottomJp =new JPanel();
        bottomJp.setBackground(Color.ORANGE);
        bottomJp.setLayout(new GridLayout(2,3));
        bottomJp.add(bb1);
        bottomJp.add(bb2);
        bottomJp.add(bb3);
        bottomJp.add(bb4);
        bottomJp.add(bb5);
        //bottomJp.add(bb6);
        
        
        getContentPane().add(topJp,BorderLayout.NORTH);
        getContentPane().add(centerJp,BorderLayout.CENTER);
        getContentPane().add(bottomJp,BorderLayout.SOUTH);
        

        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(400,400);
        
        
    }
    
    public static void main(String[] args) {
        new Layout1();
        
    }
}
