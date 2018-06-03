package FromSir.UiComponent3;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Evt1 extends JFrame implements ActionListener{
    JButton button, button2;

    public Evt1() {
        button = new JButton("OK");
        button2 = new JButton("Cancel");
        add(button);
        add(button2);
        button.addActionListener(this);
        button2.addActionListener(this);
        setLayout(new FlowLayout());
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Evt1();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
//            System.out.println("You clicked OK");
            JOptionPane.showMessageDialog(null, "You clicked OK", "Alert", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
//            System.out.println("You clicked Cancel");
            JOptionPane.showMessageDialog(this, "You clicked Cancel", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }

    
}
