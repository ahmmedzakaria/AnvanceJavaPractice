package FromSir.MouseAndKeyBordEvent;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WindowEventDemo extends JFrame
        implements WindowListener,
        WindowFocusListener,
        WindowStateListener {

    static final String newline = System.getProperty("line.separator");
    static final String space = "    ";
    static WindowEventDemo frame = new WindowEventDemo("WindowEventDemo");
    JTextArea display;

    public static void main(String[] args) {
        createAndShowGUI();
    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        //Set up the content pane.
        frame.addComponentsToPane();

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    private void addComponentsToPane() {
        display = new JTextArea();
        display.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(display);
        scrollPane.setPreferredSize(new Dimension(500, 450));
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        addWindowListener(this);
        addWindowFocusListener(this);
        addWindowStateListener(this);

        //checkWM();
    }

    public WindowEventDemo(String name) {
        super(name);
    }

    //Some window managers don't support all window states.
    public void checkWM() {
        Toolkit tk = frame.getToolkit();
        if (!(tk.isFrameStateSupported(Frame.ICONIFIED))) {
            displayMessage(
                    "Your window manager doesn't support ICONIFIED.");
        } else {
            displayMessage(
                    "Your window manager supports ICONIFIED.");
        }
        if (!(tk.isFrameStateSupported(Frame.MAXIMIZED_VERT))) {
            displayMessage(
                    "Your window manager doesn't support MAXIMIZED_VERT.");
        } else {
            displayMessage(
                    "Your window manager supports MAXIMIZED_VERT.");
        }
        if (!(tk.isFrameStateSupported(Frame.MAXIMIZED_HORIZ))) {
            displayMessage(
                    "Your window manager doesn't support MAXIMIZED_HORIZ.");
        } else {
            displayMessage(
                    "Your window manager supports MAXIMIZED_HORIZ.");
        }
        if (!(tk.isFrameStateSupported(Frame.MAXIMIZED_BOTH))) {
            displayMessage(
                    "Your window manager doesn't support MAXIMIZED_BOTH.");
        } else {
            displayMessage(
                    "Your window manager supports MAXIMIZED_BOTH.");
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        displayMessage("WindowListener method called: windowClosing.");
        //A pause so user can see the message before
        //the window actually closes.
        ActionListener task = new ActionListener() {

            boolean alreadyDisposed = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (frame.isDisplayable()) {
                    alreadyDisposed = true;
                    frame.dispose();
                }
            }
        };
        Timer timer = new Timer(500, task); //fire every half second
        timer.setInitialDelay(2000);        //first delay 2 seconds
        timer.setRepeats(false);
        timer.start();
    }

    @Override
    public void windowClosed(WindowEvent e) {
        //This will only be seen on standard output.
        displayMessage("WindowListener method called: windowClosed.");
    }

    @Override
    public void windowOpened(WindowEvent e) {
        displayMessage("WindowListener method called: windowOpened.");
    }

    @Override
    public void windowIconified(WindowEvent e) {
        displayMessage("WindowListener method called: windowIconified.");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        displayMessage("WindowListener method called: windowDeiconified.");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        displayMessage("WindowListener method called: windowActivated.");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        displayMessage("WindowListener method called: windowDeactivated.");
    }

    @Override
    public void windowGainedFocus(WindowEvent e) {
        displayMessage("WindowFocusListener method called: windowGainedFocus.");
    }

    @Override
    public void windowLostFocus(WindowEvent e) {
        displayMessage("WindowFocusListener method called: windowLostFocus.");
    }

    @Override
    public void windowStateChanged(WindowEvent e) {
        displayStateMessage(
                "WindowStateListener method called: windowStateChanged.", e);
    }

    private void displayMessage(String msg) {
        display.append(msg + newline);
        System.out.println(msg);
    }

    private void displayStateMessage(String prefix, WindowEvent e) {
        int state = e.getNewState();
        int oldState = e.getOldState();
        String msg = prefix
                + newline + space
                + "New state: "
                + convertStateToString(state)
                + newline + space
                + "Old state: "
                + convertStateToString(oldState);
        displayMessage(msg);
    }

    private String convertStateToString(int state) {
        if (state == Frame.NORMAL) {
            return "NORMAL";
        }
        String strState = " ";
        if ((state & Frame.ICONIFIED) != 0) {
            strState += "ICONIFIED";
        }
        //MAXIMIZED_BOTH is a concatenation of two bits, so
        //we need to test for an exact match.
        if ((state & Frame.MAXIMIZED_BOTH) == Frame.MAXIMIZED_BOTH) {
            strState += "MAXIMIZED_BOTH";
        } else {
            if ((state & Frame.MAXIMIZED_VERT) != 0) {
                strState += "MAXIMIZED_VERT";
            }
            if ((state & Frame.MAXIMIZED_HORIZ) != 0) {
                strState += "MAXIMIZED_HORIZ";
            }
        }
        if (" ".equals(strState)) {
            strState = "UNKNOWN";
        }
        return strState.trim();
    }
}
