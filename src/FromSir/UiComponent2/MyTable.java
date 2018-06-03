package FromSir.UiComponent2;

import java.awt.FlowLayout;
import javax.swing.*;

public class MyTable {

    JFrame f;

    MyTable() {
        f = new JFrame();
        String data[][] = {{"101", "A", "670000"},
            {"102", "B", "780000"},
            {"101", "C", "700000"}};
        String column[] = {"ID", "NAME", "SALARY"};

        JTable jt = new JTable(data, column);
        jt.getColumnModel().getColumn(0).setResizable(false);
        //jt.getModel().getColumnName(0).
        jt.setEnabled(false);
        jt.setBounds(30, 40, 200, 300);

        JScrollPane sp = new JScrollPane(jt);
        f.add(sp);

        f.setSize(300, 400);
//	f.setLayout(new FlowLayout());
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MyTable();
    }
}
