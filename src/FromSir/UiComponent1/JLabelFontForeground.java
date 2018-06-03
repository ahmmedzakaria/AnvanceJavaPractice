package FromSir.UiComponent1;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class JLabelFontForeground {
JLabel label;
    public JLabelFontForeground() {
        JFrame frame = new JFrame();
        frame.setTitle("JLabel Tesframet");
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("First Name");
        //label.setUI(new VerticalLabelUI());
        label.setFont(new Font("Courier New", Font.ITALIC+ Font.BOLD, 14));
        label.setForeground(Color.BLUE);
        /*since the default of opaque is false for JLabel
         * If true the component paints every pixel within its bounds. 
         * Otherwise, the component may not paint some or all of its pixels, 
         * allowing the underlying pixels to show through.*/
        label.setOpaque(true);
        label.setBackground(Color.PINK);
        
        label.setIcon(new ImageIcon(getClass().getResource("/img/branch.png")));

        frame.add(label);

        String htmlText =
                "<html><p><font color=\"#800080\" "
                + "size=\"5\" face=\"Verdana\">HTML in JLabel</font></p>"
                + "<font size=\"3\"><u>"
                + "underline is possible</u><br><b> and bold too</b></font>"
                + "</html>";
        JLabel lbl = new JLabel(htmlText);
        frame.add(lbl);
        frame.setSize(200, 200);
        frame.setVisible(true);
        
    }
    

    public static void main(String[] args) {
        new JLabelFontForeground();
    }
}
