package FromSir.Layout;

import java.awt.Dimension;
import javax.swing.*;
/*Glue is an invisible component that has the sole function of taking up 
 * surplus space in a Box container.*/
public class BoxLayoutEx2 extends JFrame {

    BoxLayoutEx2() {

        JPanel basic = new JPanel();
        basic.setLayout(new BoxLayout(basic, BoxLayout.Y_AXIS));
        add(basic);

        basic.add(Box.createVerticalGlue());

        JPanel bottom = new JPanel();
        bottom.setAlignmentX(1f);
        bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));

        JButton ok = new JButton("OK");
        JButton close = new JButton("Close");

        bottom.add(ok);
        bottom.add(Box.createRigidArea(new Dimension(5, 0)));
        bottom.add(close);
        bottom.add(Box.createRigidArea(new Dimension(15, 0)));

        basic.add(bottom);
        //put some space between the bottom panel and the border of the window.
        basic.add(Box.createRigidArea(new Dimension(0, 15)));

        setTitle("Two Buttons");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                BoxLayoutEx2 ex = new BoxLayoutEx2();
                ex.setVisible(true);
            }
        });
    }
}
