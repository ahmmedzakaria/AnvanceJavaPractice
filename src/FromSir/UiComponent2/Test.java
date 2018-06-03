package FromSir.UiComponent2;

import javax.swing.*;

public class Test extends JFrame{
    JLabel label1, label2, label3;
    JTextField text;
    JTextArea area;
    JScrollPane pane;
    JComboBox box;
    String[] value;
    public Test() {
        label1 = new JLabel("Name:");
        label2 = new JLabel("Address:");
        label3 = new JLabel("Country:");
        text = new JTextField();
        area = new JTextArea();
        pane = new JScrollPane(area);
        value = new String[]{"Bangladesh","India", "China"};
        box = new JComboBox(value);
        label1.setBounds(10, 20, 150, 20);
        text.setBounds(160, 20, 150, 30);
        label2.setBounds(10, 60, 150, 20);        
        pane.setBounds(160, 60, 150, 150);
        label3.setBounds(10, 220, 150, 20);
        box.setBounds(160, 220, 150, 20); 
        add(label1);
        add(text);
        add(label2);        
        add(pane);
        add(label3);
        add(box);
        setLayout(null);
        setSize(600, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Test();
    }
    
    
}
