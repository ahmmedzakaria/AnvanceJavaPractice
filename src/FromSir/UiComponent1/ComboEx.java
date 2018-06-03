package FromSir.UiComponent1;
import javax.swing.*;

public class ComboEx {
    JFrame f;
    ComboEx() {
        f = new JFrame();
        //JButton b = new JButton("click");
        String []country={"--select country--","Bangladesh","India","China","Nepal","USA","Newzealand"};
        JComboBox jb = new JComboBox(country);
        jb.setBounds(130, 100, 100, 30);
        f.add(jb);
        f.setSize(400, 300);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new ComboEx();
    } 
}
