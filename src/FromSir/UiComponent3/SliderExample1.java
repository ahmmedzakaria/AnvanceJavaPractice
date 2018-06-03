package FromSir.UiComponent3;

import javax.swing.*;

public class SliderExample1 extends JFrame {

    public SliderExample1() {
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 50, 0);
        JPanel panel = new JPanel();
        panel.add(slider);

        add(panel);
        setSize(300, 250);
    }

    public static void main(String s[]) {
        SliderExample1 frame = new SliderExample1();
        frame.pack();
        frame.setVisible(true);
    }
}