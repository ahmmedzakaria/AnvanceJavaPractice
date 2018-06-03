/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FromSir.MouseAndKeyBordEvent;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener {

    public static void main(String[] args) {

        // Create frame with specific title
        Frame frame = new Frame("Example Frame");

        // Create a component to add to the frame; in this case a text area with sample text
        Component textArea = new TextArea("You pressed []: \n");

        textArea.addKeyListener(new java.awt.event.KeyAdapter() {

           @Override
            public void keyPressed(KeyEvent evt) {
                TextArea source = (TextArea) evt.getSource();
                source.setText("You pressed [" + evt.getKeyText(evt.getKeyCode()) + "] : "+ " kEy code: "+evt.getKeyCode());
            }

//            @Override
//            public void keyTyped(KeyEvent e) {
//                 TextArea source = (TextArea) e.getSource();
//                source.setText("You typed [" + KeyEvent.getKeyText(e.getKeyCode()) + "] : ");
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//                TextArea source = (TextArea) e.getSource();
//                source.setText("You released [" + KeyEvent.getKeyText(e.getKeyCode()) + "] : ");
//            }

            
        });

        // Add the components to the frame; by default, the frame has a border layout
        frame.add(textArea, BorderLayout.NORTH);

        // Show the frame
        int width = 300;
        int height = 300;
        frame.setSize(width, height);
        frame.setVisible(true);

    }
}
