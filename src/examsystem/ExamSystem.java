/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examsystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Zakakaria
 */
public class ExamSystem {

   static QuestionFrame fm;
    public static void main(String[] args) {
        fm=new QuestionFrame();
        fm.setSize(800,600);
        Rectangle winDim=fm.getBounds();
        Dimension screenDim=Toolkit.getDefaultToolkit().getScreenSize();
        fm.setLocation((int)(screenDim.getWidth()-winDim.width)/2,
                (int)(screenDim.getHeight()-winDim.height)/2);
        fm.setIconImage(new ImageIcon("question.png").getImage());
        fm.setVisible(true);
        fm.setResizable(false);
        
        fm.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent we) {
                final JDialog jd=new JDialog();
                jd.setModal(true);
                jd.setTitle("Exam System");
                JLabel msg=new JLabel("Do You want to quit");
                final JButton okBtn=new JButton("OK");
                final JButton cancelBtn=new JButton("Cancel");
                
                okBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        System.exit(0);
                    }
                });
                
                cancelBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        jd.setVisible(false);
                    }
                });
                JPanel p=new JPanel();
                p.add(okBtn);
                p.add(cancelBtn);
                Container con=jd.getContentPane();
                con.add(msg,BorderLayout.NORTH);
                con.add(p,BorderLayout.SOUTH);
                
                jd.setSize(300,100);
                
                Rectangle winDim=jd.getBounds();
                Dimension screenDim=Toolkit.getDefaultToolkit().getScreenSize();
                jd.setLocation((int)(screenDim.getWidth()-winDim.width)/2,
                (int)(screenDim.getHeight()-winDim.height)/2);
                jd.show();
            }
           
        });
        
        
    }
    
}
