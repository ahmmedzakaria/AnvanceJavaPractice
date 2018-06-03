package content;

import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class ScrollableResultSet extends JFrame implements ActionListener {

    JPanel mainPanel;
    JTextField tempId, tempName, tempCity, tempSalary;
    JButton first, prev, next, last;
    Connection con;
    Statement stmt;
    ResultSet res;

    public ScrollableResultSet() {
        super("Scrollable Resultset Demo");
        setSize(600, 600);
        getContentPane().add(mainPanel = new JPanel());
        mainPanel.add(tempId = new JTextField(20));
        mainPanel.add(tempName = new JTextField(20));
        mainPanel.add(tempCity = new JTextField(20));
        mainPanel.add(tempSalary = new JTextField(20));
        mainPanel.add(first = new JButton("First"));
        mainPanel.add(prev = new JButton("Previous"));
        mainPanel.add(next = new JButton("Next"));
        mainPanel.add(last = new JButton("Last"));
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&password=bari123");
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            res = stmt.executeQuery("select * from emp order by name");
            if (res.next()) {
                display(res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        first.addActionListener(this);
        prev.addActionListener(this);
        next.addActionListener(this);
        last.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        Object obj = evt.getSource();
        try {
            if (obj == first) {
                if (res.first()) {
                    next.setEnabled(true);
                    display(res);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "It is not first record");
                }
            }
            if (obj == prev) {
                if (res.previous()) {
                    next.setEnabled(true);
                    display(res);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "There is no previous record");
                    prev.setEnabled(false);
                }
            }
            if (obj == next) {
                if (res.next()) {
                    prev.setEnabled(true);
                    display(res);
                } else {
                    JOptionPane.showMessageDialog(null, "It is last record");
                    next.setEnabled(false);
                }
            }
            if (obj == last) {
                if (res.last()) {
                    prev.setEnabled(true);
                    display(res);

                } else {
                    JOptionPane.showMessageDialog(null, "It is last record");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void display(ResultSet res) {
        try {
            tempId.setText(res.getString(1));
            tempName.setText(res.getString(2));
            tempCity.setText(res.getString(3));
            tempSalary.setText(res.getString(4));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ScrollableResultSet();
    }
}
