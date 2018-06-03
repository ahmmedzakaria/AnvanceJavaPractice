/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajUiComponent;

import java.awt.GraphicsEnvironment;
import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 *
 * @author Zakakaria
 */
public class SystemFont extends JFrame{
     public SystemFont(){
         GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
        String fonts[]=ge.getAvailableFontFamilyNames();
        int ttlFont=fonts.length;
        JComboBox cmb=new JComboBox(fonts);
        cmb.setBounds(130, 100, 100, 30);
        add(cmb);
        
        setSize(400, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
         setTitle("Total Fonts "+ttlFont);
    }
    
    
    public static void main(String[] args) {
        new SystemFont();
    }
}
