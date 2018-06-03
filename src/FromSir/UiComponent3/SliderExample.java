package FromSir.UiComponent3;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderExample extends JFrame implements ChangeListener{
JSlider slider;
    public SliderExample() {

         slider = new JSlider(JSlider.VERTICAL, 0, 50, 25);
        slider.setMinorTickSpacing(2);
        slider.setMajorTickSpacing(10);

        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(this);

        JPanel panel = new JPanel();
        panel.add(slider);
        add(panel);
    }

    public static void main(String s[]) {
        SliderExample frame = new SliderExample();
        frame.pack();
        frame.setVisible(true);

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        int value = slider.getValue();
        System.out.println(value);
    }
}