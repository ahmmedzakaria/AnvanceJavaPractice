package FromSir.UiComponent3;

import javax.swing.*;

public class MyProgress2 extends JFrame {
    int i;
    JProgressBar jp;

    public MyProgress2() {
        
        jp = new JProgressBar(0, 100);
        jp.setBounds(0, 0, 200, 30);
        jp.setValue(0);
        jp.setStringPainted(true);
        add(jp);
        //setTitle("Progress bar Example");
        setLayout(null);
        setSize(200, 30);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setLocationRelativeTo(null);
        //pack();
    }

    private void iterate(){
        while (i <= 100) {
            jp.setValue(i);
            i += 1;
            try {
                Thread.sleep(150);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyProgress2 mp = new MyProgress2();
        mp.setVisible(true);
        mp.iterate();
        //Main main = new Main();
        mp.dispose();
       // main.setVisible(true);
    }
}
