package FromSir.UiComponent3;

import javax.swing.*;


public class MyProgress extends JFrame{
    JProgressBar jp;
    int i;

    public MyProgress() {
        jp = new JProgressBar(0, 2000);
        jp.setBounds(50, 50, 200, 20);
        jp.setValue(0);
        jp.setStringPainted(true);
        add(jp);
        setSize(300, 300);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private void iterate(){
        while (i <= 2000) {
            jp.setValue(i);
            i += 20;
            try {
                Thread.sleep(150);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        MyProgress p  = new MyProgress();
        p.setVisible(true);
        p.iterate();
    }
    
    
}
