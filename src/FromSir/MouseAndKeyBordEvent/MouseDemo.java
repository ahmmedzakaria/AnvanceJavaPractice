
package FromSir.MouseAndKeyBordEvent;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;

public class MouseDemo extends JFrame
        implements MouseListener, MouseMotionListener {

    JTextField tf;

    public MouseDemo(String title) {
        super(title);
        tf = new JTextField(60);
        addMouseListener(this);     // Register event listener to the event source
        addMouseMotionListener(this);
        
    }

    public void launchFrame() {
        add(tf, BorderLayout.SOUTH); // Add components to the frame
        setSize(300, 300);
        setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
//        String msg = "Mouse clicked.";
//        tf.setText(msg);
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        String msg = "Mouse entered component.";
        tf.setText(msg);
    }

    @Override
    public void mouseExited(MouseEvent me) {
        String msg = "Mouse exited component.";
        tf.setText(msg);
    }

    @Override
    public void mousePressed(MouseEvent me) {
//        String msg = "Mouse pressed.";
//        tf.setText(msg);
    }

    @Override
    public void mouseReleased(MouseEvent me) {
//        String msg = "Mouse released.";
//        tf.setText(msg);
//        JOptionPane.showMessageDialog(this, msg);
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        String msg = "Mouse dragged at " + me.getX() + "," + me.getY();
        tf.setText(msg);
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        String msg = "Mouse moved at " + me.getX() + "," + me.getY();
        tf.setText(msg);
    }

    public static void main(String args[]) {
        MouseDemo med = new MouseDemo("Mouse Events Demo");      
        med.launchFrame();
    }
}
