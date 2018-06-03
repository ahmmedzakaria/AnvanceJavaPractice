package FromSir.UiComponent3;

import java.awt.FlowLayout;
import javax.swing.*;


public class Evt3 extends JFrame{
    JButton button, button2;

    public Evt3() {
        button = new JButton("OK");
        button2 = new JButton("Cancel");
        add(button);
        add(button2);
        button.addActionListener(new Evt3Listener(this));
        button2.addActionListener(new Evt3Listener(this));
        setLayout(new FlowLayout());
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Evt3();
    }   
    
}
