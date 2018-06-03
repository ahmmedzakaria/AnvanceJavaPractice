package FromSir.MouseAndKeyBordEvent;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FocusListener {

    public static void main(String[] args) {

        // Create frame with specific title
        JFrame frame = new JFrame("Example Frame");

        // Create a component to add to the frame; 
        //in this case a text area with sample text
        final TextArea textArea = new TextArea
                ("Click button to check its focus status...");

        // Create a component to add to the frame; in this case a button
        JButton button = new JButton("Click Me!!");

        // Add a focus listener to handle focus changes
        button.addFocusListener(new java.awt.event.FocusListener() {

            @Override
            public void focusGained(FocusEvent evt) {
                textArea.setText(textArea.getText() + "\nButton focus gained");
            }

            @Override
            public void focusLost(FocusEvent evt) {
                textArea.setText(textArea.getText() + "\nButton focus lost");
            }
        });

        // Add the components to the frame; by default, 
        //the frame has a border layout
        frame.add(textArea, BorderLayout.NORTH);
        frame.add(button, BorderLayout.SOUTH);

        // Show the frame
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
