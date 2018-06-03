package FromSir.UiComponent3;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Evt2 extends JFrame{
    JButton button, button2;

    public Evt2() {
        button = new JButton("OK");
        button2 = new JButton("Cancel");
        add(button);
        add(button2);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              JOptionPane.showMessageDialog(rootPane, "You clicked OK", "Alert", JOptionPane.INFORMATION_MESSAGE);  
            }
        });
        button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              JOptionPane.showMessageDialog(rootPane, "You clicked Cancel", "Alert", JOptionPane.WARNING_MESSAGE);  
            }
        });        
        setLayout(new FlowLayout());
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Evt2();
    }   
    
}
