package FromSir.UiComponent3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Evt3Listener implements ActionListener {

    JFrame frame;

    Evt3Listener(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("OK")) {
            JOptionPane.showMessageDialog(frame, "You clicked OK", "Alert", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frame, "You clicked Cancel", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }
}
