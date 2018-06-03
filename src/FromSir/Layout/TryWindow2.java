package FromSir.Layout;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Dimension;

public class TryWindow2 {
    // The window object

    static JFrame aWindow = new JFrame("This is the Window Title");

    public static void main(String[] args) {
        Toolkit theKit = aWindow.getToolkit(); // Get the window toolkit
        Dimension wndSize = theKit.getScreenSize();  // Get screen size
        System.out.println("Window Height"+wndSize.height);
        System.out.println("Window Width"+wndSize.width);
        // Set the position to screen center & size to half screen size
        aWindow.setBounds(wndSize.width / 4, wndSize.height / 4, // Position
                wndSize.width / 2, wndSize.height / 2);  // Size
        aWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aWindow.setVisible(true);                    // Display the window
    }
}
