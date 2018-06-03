/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajUiComponent;

import java.awt.Font;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 *
 * @author Zakakaria
 */
public class ComboBox extends JFrame{

    public ComboBox(){
        ArrayList<String> list=new ArrayList<String>();
         try {
            RandomAccessFile raf = new RandomAccessFile(new File("country.txt"), "r");
            while(raf.readLine()!=null){
            String line = raf.readLine();
            String utf8 = new String(line.getBytes("ISO-8859-1"), "UTF-8");
            list.add(utf8);
            }
            
        } catch (Exception e) {
        }
         
         
         ArrayList<String> list2=new ArrayList<String>();
        try {
            InputStreamReader ir=new InputStreamReader(new FileInputStream("country.txt"),"UTF-8");
            BufferedReader in=new BufferedReader(ir);

            char u='\n';
            int i;
            //StringBuffer coun=new StringBuffer("বাংলাদেশ");
           // StringBuffer coun=new StringBuffer("oi");
            StringBuffer sb=new StringBuffer();
            while ((i = in.read()) != -1) {
                
                //if(i==(int)b)
                if(i!=(int)u){
                    char c=(char)i;
                    //sb+=(char)i;
                    sb.append(c);
                    //System.out.println(sb);
                }else{
//                    System.out.println(sb.toString());
//                    if(new String(sb).equals("oi")){
//                        System.out.println(sb);
//                    sb=new StringBuffer();
//                    }
                    list2.add(sb.toString());
                    sb=new StringBuffer();
                    
                }

            }

            in.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        String cmbItem[]={"Dhaka","Gazipur","Foridpur"};
        JComboBox cmb=new JComboBox(list2.toArray());
        cmb.setFont(new Font("Siyam Rupali",Font.BOLD,20));
        cmb.setBounds(130, 100, 100, 30);
        add(cmb);
        
        setSize(400, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
    
    public static void main(String[] args) {
        new ComboBox();
    }
}
