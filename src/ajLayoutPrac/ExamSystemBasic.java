package ajLayoutPrac;

import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
  
class ExamSystemBasic extends JFrame implements ActionListener  
{  
    JLabel l;  
    JRadioButton jb[]=new JRadioButton[5];  
    JButton b1,b2,b3;  
    ButtonGroup bg;  
    int count=0,current=0,x=1,y=1,now=0;  
    int m[]=new int[10];  
    int notSelected=9;
    ExamSystemBasic(String s)  
    {  
        super(s);  
        l=new JLabel();  
        add(l);  
        bg=new ButtonGroup();  
        for(int i=0;i<5;i++)  
        {  
            jb[i]=new JRadioButton();     
            add(jb[i]);  
            bg.add(jb[i]);  
        }  
        b1=new JButton("Next");  
        b2=new JButton("Result");  
       
        b3 = new JButton("Previes");
        //Use the default text position of CENTER, TRAILING (RIGHT).
        b3.setMnemonic(KeyEvent.VK_E);
        b3.setActionCommand("enable");
        //b3.setEnabled(false)
        b1.addActionListener(this);  
       //b2.addActionListener(this);
        b3.addActionListener(this); 
        b2.addActionListener(this);
        
        add(b1);
        add(b2);  
        add(b3);
        b3.setToolTipText("Click this button to enable the "
                + "middle button.");
        set();  
        l.setBounds(30,40,450,20);  
        jb[0].setBounds(50,80,100,20);  
        jb[1].setBounds(50,110,100,20);  
        jb[2].setBounds(50,140,100,20);  
        jb[3].setBounds(50,170,100,20); 
        
        b1.setBounds(100,240,100,30); 
        b2.setBounds(440,240,100,30);
        b3.setBounds(270,240,100,30); 
        jb[0].setBackground(Color.cyan); 
        jb[1].setBackground(Color.cyan);
        jb[2].setBackground(Color.cyan);
        jb[3].setBackground(Color.cyan);
        jb[4].setBackground(Color.cyan);
        b1.setBackground(Color.DARK_GRAY); 
        b2.setBackground(Color.DARK_GRAY); 
        b1.setForeground(Color.WHITE);
        b2.setForeground(Color.WHITE);
        this.getContentPane().setBackground(Color.lightGray); 
        l.setForeground(Color.darkGray);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLayout(null);  
        setLocation(250,100);  
        setVisible(true);  
        setSize(600,350);  
    }  
    public void actionPerformed(ActionEvent e)  
    { 
    	if (e.getActionCommand().equals("Previes")) {
            b2.setEnabled(false);
            b1.setEnabled(false);
            b3.setEnabled(true);
        } else {
            b2.setEnabled(true);
            b1.setEnabled(true);
            //b3.setEnabled(false);
        }
        if(e.getSource()==b1)  
        {  
            if(check())  
                count=count+1;  
            current++; 
            set();    
            if(current==9)  
            {  
                b1.setEnabled(false); 
                b3.setEnabled(true);
                
                //b2.setText("Submit");  
            } else if(current<9) {
            	b3.setEnabled(true);
            } 
        }  
        
        if(e.getSource()==b3)  
        {  
            if(check())  
                count=count+1;  
            current--; 
            System.out.println("Prev"+current);
            set();    
            if(current<1)  
            {  
                b3.setEnabled(false);  
                //b2.setText("Submit");  
            }else {
            	//b3.setEnabled(true);
            }  
        } 
        
        if(e.getActionCommand().equals("Result"))  
        {  
//            JButton bk=new JButton("Result"+x);  
//            bk.setBounds(480,20+30*x,100,30);  
//            add(bk);  
//            bk.addActionListener(this);  
//            m[x]=current;  
//            x++;  
//            current++;  
//            set();    
//            if(current==9)  
//                b2.setText("Submit");  
//            setVisible(false);  
//            setVisible(true);  
            //System.out.println(notSelected);
            if(notSelected>0){
                JOptionPane.showMessageDialog(this, "Attempt All the Qustions","Alert",JOptionPane.WARNING_MESSAGE);
            }else{
            JOptionPane.showMessageDialog(this, "Total Correct: "+count,"Alert",JOptionPane.WARNING_MESSAGE);
            }
        }  
        for(int i=0,y=1;i<x;i++,y++)  
        {  
        if(e.getActionCommand().equals("Bookmark"+y))  
        {  
            if(check())  
                count=count+1;  
            now=current;  
            current=m[y];  
            set();  
            ((JButton)e.getSource()).setEnabled(false);  
            current=now;  
        }  
        }  
      
        if(e.getActionCommand().equals("Submit"))  
        {  
            if(check())  
                count=count+1;  
            current++;  
            //System.out.println("correct ans="+count);  
            JOptionPane.showMessageDialog(this,"correct ans="+count);  
            System.exit(0);  
        }  
    }  
    void set()  
    {  
        jb[4].setSelected(true);  
        if(current==0)  
        {  
            l.setText("Que1: Which one among these is not a primitive datatype?");  
            jb[0].setText("int");jb[1].setText("Float");jb[2].setText("boolean");jb[3].setText("char");   
        }  
        if(current==1)  
        {  
            l.setText("Que2: Which class is available to all the class automatically?");  
            jb[0].setText("Swing");jb[1].setText("Applet");jb[2].setText("Object");jb[3].setText("ActionEvent");  
        }  
        if(current==2)  
        {  
            l.setText("Que3: Which package is directly available to our class without importing it?");  
            jb[0].setText("swing");jb[1].setText("applet");jb[2].setText("net");jb[3].setText("lang");  
        }  
        if(current==3)  
        {  
            l.setText("Que4: String class is defined in which package?");  
            jb[0].setText("lang");jb[1].setText("Swing");jb[2].setText("Applet");jb[3].setText("awt");  
        }  
        if(current==4)  
        {  
            l.setText("Que5: Which institute is best for java coaching?");  
            jb[0].setText("Utek");jb[1].setText("Aptech");jb[2].setText("SSS IT");jb[3].setText("jtek");  
        }  
        if(current==5)  
        {  
            l.setText("Que6: Which one among these is not a keyword?");  
            jb[0].setText("class");jb[1].setText("int");jb[2].setText("get");jb[3].setText("if");  
        }  
        if(current==6)  
        {  
            l.setText("Que7: Which one among these is not a class? ");  
            jb[0].setText("Swing");jb[1].setText("Actionperformed");jb[2].setText("ActionEvent");  
                        jb[3].setText("Button");  
        }  
        if(current==7)  
        {  
            l.setText("Que8: which one among these is not a function of Object class?");  
            jb[0].setText("toString");jb[1].setText("finalize");jb[2].setText("equals");  
                        jb[3].setText("getDocumentBase");         
        }  
        if(current==8)  
        {  
            l.setText("Que9: which function is not present in Applet class?");  
            jb[0].setText("init");jb[1].setText("main");jb[2].setText("start");jb[3].setText("destroy");  
        }  
        if(current==9)  
        {  
            l.setText("Que10: Which one among these is not a valid component?");  
            jb[0].setText("JButton");jb[1].setText("JList");jb[2].setText("JButtonGroup");  
                        jb[3].setText("JTextArea");  
        }  
        l.setBounds(30,40,450,20);  
        for(int i=0,j=0;i<=90;i+=30,j++)  
            jb[j].setBounds(50,80+i,200,20);  
            
    } 
    boolean checkradio(boolean x){
     if(x){
                notSelected--;
                return true;
            }else{
            for (int i = 0; i < 4; i++) {
                if(jb[i].isSelected()){
                    notSelected--;
                    break;
                } 
            }
            return false;
        }
    }
    boolean check() 
            
    {  
        if(current==0) 
        return checkradio(jb[1].isSelected()); 
              
        if(current==1)  
            return checkradio(jb[2].isSelected());
            //return(jb[2].isSelected());  
        if(current==2)
            return checkradio(jb[3].isSelected());
            //return(jb[3].isSelected());  
        if(current==3)  
            return checkradio(jb[0].isSelected());
            //return(jb[0].isSelected());  
        if(current==4)  
            return checkradio(jb[2].isSelected());
            //return(jb[2].isSelected());  
        if(current==5)
            return checkradio(jb[2].isSelected());
            //return(jb[2].isSelected());  
        if(current==6) 
            return checkradio(jb[1].isSelected());
            //return(jb[1].isSelected());  
        if(current==7)
            return checkradio(jb[3].isSelected());
            //return(jb[3].isSelected());  
        if(current==8) 
            return checkradio(jb[1].isSelected());
            //return(jb[1].isSelected());  
        if(current==9)  
            return checkradio(jb[2].isSelected());
            //return(jb[2].isSelected());  
        return false;  
    }  
    public static void main(String args[])  
    {  
        new ExamSystemBasic("Joshim Online Test by using Swing in Java");  
    }  
}