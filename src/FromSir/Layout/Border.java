package FromSir.Layout;

import java.awt.*;
import javax.swing.*;
/*The border layout manager is intended to place up to five components 
 * in a container. Possible positions for these components are 
 * on any of the four borders of the container and in the center. 
 * Only one component can be at each position. If you add a component 
 * at a position that is already occupied, the previous component 
 * will be displaced. A border is selected by specifying a constraint 
 * that can be NORTH, SOUTH, EAST, WEST, or CENTER.
 */
public class Border {

    JFrame f;

    Border() {
        f = new JFrame();

        JButton b1 = new JButton("NORTH");
        JButton b2 = new JButton("SOUTH");
        JButton b3 = new JButton("EAST");
        JButton b4 = new JButton("WEST");
        JButton b5 = new JButton("CENTER");
        JButton b6 = new JButton("Extra");
        JPanel npanel = new JPanel();
        npanel.setLayout(new FlowLayout());
        npanel.add(b1);
        npanel.add(b6);
        f.setLayout(new BorderLayout(10, 10));
        f.add(npanel, BorderLayout.NORTH);
        f.add(b2, BorderLayout.SOUTH);
        f.add(b3, BorderLayout.EAST);
        f.add(b4, BorderLayout.WEST);
        f.add(b5, BorderLayout.CENTER);
        //f.add(b6, BorderLayout.NORTH);
        f.setSize(300, 300);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new Border();
    }
}
