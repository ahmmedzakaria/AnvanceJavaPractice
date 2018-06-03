package FromSir.UiComponent2;

import java.awt.Color;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

public class TArea {
    JTextArea area;
    JLabel lbl;
    JFrame f;
    JScrollPane jp;
	TArea(){
	f=new JFrame();
		
	area=new JTextArea(300,300);
        lbl = new JLabel("Enter Text");
        jp = new JScrollPane(area);
	jp.setBounds(10,30,300,300);
        lbl.setBounds(10, 10, 100, 20);
	
	area.setBackground(Color.DARK_GRAY);
	area.setForeground(Color.white);
        lbl.setForeground(Color.RED);
		
	f.add(jp);
	f.add(lbl);
	f.setSize(400,400);
	f.setLayout(null);
	f.setVisible(true);
}
	public static void main(String[] args) {
		new TArea();
	}
}
