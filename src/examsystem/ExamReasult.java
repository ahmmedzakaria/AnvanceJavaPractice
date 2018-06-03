/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examsystem;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import examsystem.Properties;
import examsystem.QuestionFrame;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author Zakakaria
 */
public class ExamReasult extends JDialog{
    Properties properties;
    JLabel totalQuestion, totalAns, totalWorong, percentage;
    JButton okBtn;
    int correct;

    public ExamReasult(final QuestionFrame fm, int correctAnswer) {
        correct=correctAnswer;
        properties=new Properties();
        totalQuestion =new JLabel("Total Questions");
        totalAns =new JLabel("Correct Answars");
        totalWorong =new JLabel("Worong Answar");
        percentage =new JLabel("Percentage");
        
        okBtn=new JButton("Ok End Test");
        setTitle("Exam Result");
        setModal(true);
        
//        for (int i = 0; i < fm.ansOption.length; i++) {
//            System.out.println(i);
//            for (int j = 0; j < fm.ansOption[i].length; j++) {
//                System.out.print(fm.ansOption[i][j]+" ");
//            }
//            
//        }
        
//        for (int i = 1; i < properties.getTotalQuestions(); i++) {
//            StringBuffer s=new StringBuffer();
//            for (int j = 0; j < properties.getAnswarOptions(); j++) {
//                if(fm.ansOption[i][j]==true){
//                    s.append(j+1+",");
//                    System.out.println(s);
//                }
//                if(s.length()!=0){
//                    s.deleteCharAt(s.length()-1);
//                }
//                //System.out.println(fm.qustionOption[i][6]);
//                if(fm.qustionOption[i][6].equals(new String(s))){
//                    correct++;
//                }    
//            }       
//        }
        
         int p=(correct*100)/properties.getTotalQuestions();
                
                Container content=getContentPane();
                JPanel resultPnl=new JPanel();
                resultPnl.setLayout(new GridLayout(5,2));
                resultPnl.add(totalQuestion);
                resultPnl.add(new JLabel(""+properties.getTotalQuestions()));
                resultPnl.add(totalAns);
                resultPnl.add(new JLabel(""+correct));
                resultPnl.add(totalWorong);
                resultPnl.add(new JLabel((properties.getTotalQuestions()-correct)+""));
                resultPnl.add(percentage);
                resultPnl.add(new JLabel(p+""));
                content.add(resultPnl,BorderLayout.NORTH);
                
                okBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                      fm.ansOption=new boolean[properties.getTotalQuestions()][6];
                     
                       dispose();
                    }
                });
                Rectangle winDim=getBounds();
                Dimension screenDim=Toolkit.getDefaultToolkit().getScreenSize();
                setLocation((int)(screenDim.getWidth()-winDim.width)/2,
                (int)(screenDim.getHeight()-winDim.height)/2);
                resultPnl.add(okBtn);
                setSize(300, 300);
                setVisible(true);
                setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
        
    }
    
    
}
