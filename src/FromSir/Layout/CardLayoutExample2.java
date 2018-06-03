package FromSir.Layout;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*The card layout manager generates a stack of components, 
 * one on top of the other. The first component that you add to the 
 * container will be at the top of the stack, and therefore visible, 
 * and the last one will be at the bottom. 
 */

public class CardLayoutExample2 extends JFrame implements ActionListener {

    CardLayout card;
    JButton b1, b2, b3;
    Container c;

    CardLayoutExample2() {
        c = getContentPane();
        //create CardLayout object with 40 hor space and 30 ver space
        card = new CardLayout(40, 30);
        c.setLayout(card);

        b1 = new JButton("A");
        b1.setBackground(Color.yellow);
        b1.setSize(200, 100);
        b2 = new JButton("B");
        b2.setBackground(Color.green);
        b2.setSize(100, 100);
        b3 = new JButton("C");
        b3.setBackground(Color.blue);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        c.add("a", b1);
        c.add("b", b2);
        c.add("c", b3);
    }

    public static void main(String[] args) {
        CardLayoutExample2 cl = new CardLayoutExample2();
        cl.setSize(400, 400);
        cl.setVisible(true);
        cl.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        card.next(c);
    }
}
