/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FromSir.UiComponent1;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class PlafTest extends JPanel implements ActionListener {
  private JButton metalButton = new JButton("Metal");

  private JButton motifButton = new JButton("Motif");

  private JButton windowsButton = new JButton("Windows");
  private JButton classicButton = new JButton("Clasic");
  private JButton nimbusButton = new JButton("Nimbus");

  public PlafTest() {

    add(metalButton);
    add(motifButton);
    add(windowsButton);
    add(classicButton);
    add(nimbusButton);
    metalButton.addActionListener(this);
    motifButton.addActionListener(this);
    windowsButton.addActionListener(this);
    classicButton.addActionListener(this);
    nimbusButton.addActionListener(this);
  }

  public void actionPerformed(ActionEvent evt) {
    Object source = evt.getSource();
    String plaf = "";
    if (source == metalButton)
      plaf = "javax.swing.plaf.metal.MetalLookAndFeel";
    else if (source == motifButton)
      plaf = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
    else if (source == windowsButton)
      plaf = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
    else if (source == classicButton)
      plaf = "com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel";
    else if (source == nimbusButton)
      plaf = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
    try {
      UIManager.setLookAndFeel(plaf);
      SwingUtilities.updateComponentTreeUI(this);
    } catch (Exception e) {
    }
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setTitle("PlafTest");
    frame.setSize(300, 200);
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    Container contentPane = frame.getContentPane();
    contentPane.add(new PlafTest());

    frame.show();
  }
}
