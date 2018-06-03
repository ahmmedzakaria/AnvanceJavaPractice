/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examsystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.RandomAccess;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Zakakaria
 */
public class QuestionFrame extends JFrame {
    int correct = 0;
    int missedAnswer=0;
    int maxQuestion = 1, questionNo = 2;
    JLabel questionNoJL, timerJL;
    TextArea questionAreaTA;
    JCheckBox answerJC[], marksJC;

    JPanel topPN, centerPN, bottomPN;
    JButton nextBtn, previousBtn, gradeBtn, reviewBtn;

    String qustionOption[][];
    boolean ansOption[][];
    Question ques;
    Properties properties;

    public QuestionFrame() {
        properties = new Properties();
        qustionOption = new String[properties.getTotalQuestions()][7];
        ansOption = new boolean[properties.getTotalQuestions()][6];
        ques = new Question();
        qustionOption = ques.getQuestions();
        questionNoJL = new JLabel();
        timerJL = new JLabel("Timer", JLabel.RIGHT);
        questionAreaTA = new TextArea();
        questionAreaTA.setBackground(properties.getTxtAreaColor());
        answerJC = new JCheckBox[5];
        marksJC = new JCheckBox("Mark");
        setTitle("Exam System");
        //rootPane.setBackground(properties.getBgcColor());
        topPN = new JPanel();
        
        //topPN.setSize(getBounds().width, 200);
        topPN.setBackground(properties.getBgcColor());;
       // topPN.setSize(100,400);
        centerPN = new JPanel();
        centerPN.setBackground(properties.getBgcColor());

        centerPN.setLayout(new GridLayout(5, 1));

        topPN.setLayout(new BorderLayout());//
        topPN.add(questionNoJL, BorderLayout.WEST);
        //topPN.add(marksJC, BorderLayout.EAST);
        topPN.add(timerJL, BorderLayout.EAST);
        topPN.add(questionAreaTA, BorderLayout.SOUTH);

        for (int i = 0; i < 5; i++) {
            answerJC[i] = new JCheckBox();
            answerJC[i].setBackground(properties.getBgcColor());
            answerJC[i].addItemListener(new ItemList());
            centerPN.add(answerJC[i]);
            answerJC[i].setFont(new Font("Serieff", Font.PLAIN, 12));
        }
        bottomPN = new JPanel();
        bottomPN.setBackground(properties.getBgcColor());
        bottomPN.setLayout(new GridLayout(1, 5));
        nextBtn = new JButton("Next");
        //nextBtn.setSize(200,80);
        nextBtn.setBackground(properties.getBtnColor());
        previousBtn = new JButton("Previous");
        previousBtn.setBackground(properties.getBtnColor());
        reviewBtn = new JButton("Review");
        reviewBtn.setBackground(properties.getBtnColor());
        gradeBtn = new JButton("End Test");
        gradeBtn.setBackground(properties.getBtnColor());
        previousBtn.setEnabled(false);

        bottomPN.add(previousBtn);
        bottomPN.add(nextBtn);
        bottomPN.add(gradeBtn);
        bottomPN.add(reviewBtn);

        getContentPane().add(topPN, BorderLayout.NORTH);
        getContentPane().add(centerPN, BorderLayout.CENTER);
        getContentPane().add(bottomPN, BorderLayout.SOUTH);

        nextBtn.addActionListener(new ActionList());
        previousBtn.addActionListener(new ActionList());
        gradeBtn.addActionListener(new ActionList());
        reviewBtn.addActionListener(new ActionList());
        makeQuestions(questionNo);
        Timer t=new Timer(this);
        t.start();

    }

    void makeQuestions(int num) {
        if (num > 0 && num <= (properties.getTotalQuestions() - 1)) {
            questionNoJL.setText("Qustion No " + num + " of " + (properties.getTotalQuestions() - 1));
            //for(int k=0;k<qustionOption[num-1].length;k++){System.out.println("Num "+num+qustionOption[num-1][k]);}
            questionAreaTA.setText(qustionOption[num - 1][0]);
            //String s=qustionOption[num-1][1]+"\n"+qustionOption[num-1][2]+"\n"+qustionOption[num-1][3]+"\n";
            //questionAreaTA.setText(qustionOption[num-1][0]+"\n"+s);
            questionAreaTA.setRows(properties.getTotalQuestions() - 1);
            if (maxQuestion < num) {
                maxQuestion = num;
                // for(int k=0;k<qustionOption[num-1].length;k++){System.out.println(qustionOption[num-1].length+qustionOption[num-1][k]);}
                for (int i = 0; i < 5; i++) {
                    // System.out.println("Num "+num+"i "+i);
                    if (qustionOption[num - 1][i + 1].length() <= 1) {
                        //System.out.println("Less then 0");
                        answerJC[i].setVisible(false);
                    }
                    if (qustionOption[num - 1][i + 1].length() > 0) {
                       // System.out.println("Num " + num + " Ans: " + qustionOption[num - 1][i + 1]);
                        answerJC[i].setVisible(true);
                        answerJC[i].setSelected(false);
                        answerJC[i].setText(qustionOption[num - 1][i + 1]);
                        //answerJC[i].setVisible(false);
                        //System.out.println(qustionOption[num-1][i+1]);
                    } else if (qustionOption[num - 1][i + 1].equals(null)) {
                        //System.out.println("Else");
                        answerJC[i].setVisible(false);
                    }
                    marksJC.setSelected(false);
                    //marksJC.setVisible(false);
                }

            } else {
                for (int i = 0; i < 5; i++) {
                    if (!qustionOption[num - 1][i + 1].equals(null)) {
                        answerJC[i].setVisible(true);
                        answerJC[i].setSelected(ansOption[num - 1][i]);
                        answerJC[i].setText(qustionOption[num - 1][i + 1]);
                    } else {
                        answerJC[i].setVisible(false);
                    }
                    marksJC.setSelected(false);
                }
            }

        }
    }

    class ActionList implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == nextBtn) {
                if (questionNo < (properties.getTotalQuestions() - 1)) {
                    nextBtn.setEnabled(true);
                    previousBtn.setEnabled(true);
                    questionNo += 1;
                    if (questionNo >= (properties.getTotalQuestions() - 1)) {
                        nextBtn.setEnabled(false);
                    }
                    makeQuestions(questionNo);
                }
            } else if (e.getSource() == previousBtn) {
                if (questionNo > 0) {
                    nextBtn.setEnabled(true);
                    previousBtn.setEnabled(true);
                    questionNo -= 1;
                    if (questionNo <= 1) {
                        previousBtn.setEnabled(false);
                    }
                    makeQuestions(questionNo);

                }
            } else if (e.getSource() == gradeBtn) {

//            for (int i = 0; i < ansOption.length; i++) {
//            System.out.println(i);
//            for (int j = 0; j < ansOption[i].length; j++) {
//                System.out.print(ansOption[i][j]+" ");
//            }
//            
//        }
                
                try {
                    missedAnswer=0;
                    for (int i = 1; i < properties.getTotalQuestions(); i++) {
                        StringBuffer s = new StringBuffer();
                        int count=0;
                        for (int j = 0; j < properties.getAnswarOptions(); j++) {
                            if (ansOption[i][j] == true) {
                                s.append(j + 1 + ",");
                                count++;
                            }
                        }
//                        if(count>0){
//                            missedAnswer++;
//                        }
                        if (s.length() != 0) {
                            s.deleteCharAt(s.length() - 1);
                        }else{
                        missedAnswer++;
                        }
                        //System.out.println(fm.qustionOption[i][6]);
                        if (qustionOption[i][6].equals(new String(s))) {
                            correct++;
                        }
                    }
                } catch (Exception ex) {
                }
                System.out.println("correct Answer: " + missedAnswer);
                if(missedAnswer==1){
                    new ExamReasult(ExamSystem.fm, correct);
                }else{
                    
                    JOptionPane.showMessageDialog(ExamSystem.fm,"Please Atempt all the Questions","Alert",JOptionPane.WARNING_MESSAGE);
                }

            }
        }

    }

    class ItemList implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            JCheckBox jc = (JCheckBox) e.getItem();
            for (int i = 0; i < 5; i++) {
                JCheckBox jCheckBox = answerJC[i];

                if (e.getStateChange() == 1) {
                    if (jc == answerJC[i]) {
                        ansOption[questionNo - 1][i] = true;
                        // System.out.println(ansOption[questionNo-1][i]);
                    }

                } else {
                    if (jc == answerJC[i]) {
                        ansOption[questionNo - 1][i] = false;
                    }

                }

            }
        }

    }

    class Question {

        RandomAccessFile file;
        String questionOption[][];

        public Question() {
            try {
                questionOption = new String[properties.getTotalQuestions()][7];
                file = new RandomAccessFile("questions2.txt", "r");

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }

        }

        String[][] getQuestions() {
//        int count=0;
//        while(true){
//            String arr[]=getOneQustions();
//            if(arr[0].equals(null)){
//                continue;
//            }else{
//            
//                for (int i = 0; i < arr.length; i++) {
//                    qustionOption[count][i] = arr[i];
//                    
//                }
//                count++;
//            }
//            if(count==properties.getAnswarOptions()-2){
//                break;
//            }
//        
//        }
//        

            StringBuffer s1;
            try {
                for (int i = 0; i < (properties.getTotalQuestions() - 1); i++) {
                    //System.out.println("Start value: "+i);
                    StringBuffer sb1 = new StringBuffer();

//                bl:
//                while (true) {
//                    String sb=file.readLine();
//                    if(sb!=null){
//                    String temp = new String();
//                    System.out.println(temp);
//           
//                    if (temp.equals("##-----Question-----##")) {
//                        
//                        int k = (int) Math.ceil(Math.random() * 2);
//                        switch (k) {
//                            case 2:
//                                break bl;
//                        }
//                    }
//                    }
//                }
                    while (true) {

                        s1 = new StringBuffer(file.readLine());
                        if (new String(s1) != null) {
                            //System.out.println(s1);
                            if (new String(s1).equals("##-----Question-----##")) {
                                break;
                            } else if (new String(s1).equals("##ans1##")) {
                                // System.out.println("value: "+i);
                                questionOption[i][1] = file.readLine();
                                //System.out.println(questionOption[i][1]);
                            } else if (new String(s1).equals("##ans2##")) {
                                questionOption[i][2] = file.readLine();
                            } else if (new String(s1).equals("##ans3##")) {
                                questionOption[i][3] = file.readLine();
                            } else if (new String(s1).equals("##ans4##")) {
                                questionOption[i][4] = file.readLine();
                            } else if (new String(s1).equals("##ans5##")) {
                                questionOption[i][5] = file.readLine();
                            } else if (new String(s1).equals("##correct##")) {
                                questionOption[i][6] = file.readLine();
                            } else {
                                sb1.append(s1);
                                sb1.append("\n");
                                questionOption[i][0] = new String(sb1);

                            }
                            //for(int k=0;k<questionOption[i].length;k++){System.out.println(questionOption[i][k]);}
                        } else {
                            //System.out.println("Start value2 else: " + i);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return questionOption;
        }
        int count = 0;

//    String[] getOneQustions(){
//        String arr[]=new String[7];
//        try {
//            
//            StringBuffer sb1 = new StringBuffer();
//            StringBuffer s1;
//            s1=new StringBuffer(file.readLine());
//            if(new String(s1)!=null){
//                //System.out.println(s1);
//                if(new String(s1).equals("##ans1##")){
//                    // System.out.println("value: "+i);
//                    arr[1]=file.readLine();
//                    //System.out.println(arr[][1]);
//                } else if(new String(s1).equals("##ans2##")){
//                    arr[2]=file.readLine();
//                } else if(new String(s1).equals("##ans3##")){
//                    arr[3]=file.readLine();
//                } else if(new String(s1).equals("##ans4##")){
//                    arr[4]=file.readLine();
//                } else if(new String(s1).equals("##ans5##")){
//                    arr[5]=file.readLine();
//                } else if(new String(s1).equals("##correct##")){
//                    arr[6]=file.readLine();
//                }else{
//                    sb1.append(s1);
//                    sb1.append("\n");
//                    arr[0]=new String(sb1);
//                    
//                }
//                //for(int k=0;k<questionOption[i].length;k++){System.out.println(questionOption[i][k]);}
//            }
//        } catch (IOException ex) {
//            arr[0]=null;
//        }
//        return arr;
//    }
    }
}
