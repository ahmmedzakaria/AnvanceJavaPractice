package FromSir.UiComponent2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class JmenuExample extends JFrame implements ActionListener {

    JMenuBar bar;
    JMenu mnu1, mnu2, mnu3, mnu4;
    JMenuItem item1, item2, item3, item4;

    JmenuExample() {
        //creating objects
        bar = new JMenuBar();
        mnu1 = new JMenu("File");
        mnu2 = new JMenu("Entry");
        mnu3 = new JMenu("help");
        mnu4 = new JMenu("Quit");
        item1 = new JMenuItem("Exit");
        item2 = new JMenuItem("New");
        item3 = new JMenuItem("Open");
        item4 = new JMenuItem("About");
        item1.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        item1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/branch.png")));

        mnu1.add(item1);
        mnu1.add(item3);
        mnu2.add(item2);
        mnu3.add(item4);
        mnu2.add(mnu3);
        bar.add(mnu1);
        bar.add(mnu2);
        bar.add(mnu4);
        setJMenuBar(bar);
        item1.addActionListener(this);
        item2.addActionListener(this);
        mnu4.addActionListener(this);

//        item1.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//              System.exit(0);
//            }
//        });
//        


        mnu4.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int x = JOptionPane.showConfirmDialog(rootPane, "Are u sure?", "Confirmation", JOptionPane.OK_CANCEL_OPTION);
                if (x == JOptionPane.OK_OPTION) {
                    System.out.println(x);
                    System.exit(0);
                }
            }
        });

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        new JmenuExample();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == item1) {
            int x = JOptionPane.showConfirmDialog(this, "Are u Sure?", "Confirmation", JOptionPane.OK_CANCEL_OPTION);
            if (x == 0) {
                System.out.println(x);
                System.exit(0);
            } else {
            }
        }

        if (e.getSource() == item2) {
            NewJFrame jf = new NewJFrame();
            jf.setVisible(true);
        }
    }
}
