/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examsystem;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 *
 * @author Zakakaria
 */
public class Timer extends Thread {

    QuestionFrame qf;
    private int min, second;
    private String sMin, sSecond;
    Properties properties;

    public Timer(QuestionFrame qf) {
        properties=new Properties();
        this.qf = qf;
    }

    @Override
    public void run() {
        min = properties.getTotalQuestions() * 2-3;
        
        second = 60;

        while (true) {
            try {
                sleep(1000);
            } catch (Exception e) {
            }
            second -= 1;

            if (second < 1) {
                min -= 1;
                second = 60;
            }

            if (min < 10) {
                sMin = "0" + min;
            } else {
                sMin = "" + min;
            }

            if (second < 10) {
                sSecond = "0" + second;
            } else {
                sSecond = "" + second;
            }

            qf.timerJL.setText("Time: " + sMin + " : " + sSecond);
            if (min < 1 && second == 0) {
                final JDialog jd = new JDialog(qf, true);
                JButton btn = new JButton("OK");
                JLabel lbl = new JLabel("Time Up", JLabel.CENTER);
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        qf.nextBtn.setEnabled(false);
                        qf.previousBtn.setEnabled(false);
                        jd.dispose();
                    }
                });
                Rectangle winDim=jd.getBounds();
                Dimension screenDim=Toolkit.getDefaultToolkit().getScreenSize();
                jd.setLocation((int)(screenDim.getWidth()-winDim.width)/2,
                (int)(screenDim.getHeight()-winDim.height)/2);
                Container con = jd.getContentPane();
                con.add(lbl, BorderLayout.NORTH);
                con.add(btn, BorderLayout.SOUTH);
                jd.setSize(200, 200);
                jd.setVisible(true);
                new ExamReasult(qf,qf.correct);
                break;

            }
        }
    }

}
