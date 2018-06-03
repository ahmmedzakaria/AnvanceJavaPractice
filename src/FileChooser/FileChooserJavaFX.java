/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileChooser;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;

/**
 *
 * @author Zakakaria
 */
public class FileChooserJavaFX {
    static File path;
    static String fileName;
    
    public static void main(String[] args) {
        
        
         try {
            FileChooser chooser = new FileChooser();
            
            chooser.setInitialDirectory(path);
            File file = chooser.showOpenDialog(null);
            path = new File(file.getParent());
            chooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Image", "*.png")
            );
            
            fileName = file.getName();
            System.out.println(file);
            System.out.println("getAbsoluteFile "+file.getAbsoluteFile());
            System.out.println("getCanonicalPath "+file.getCanonicalPath());
            System.out.println("getName "+file.getName());
            System.out.println("getParent "+file.getParent());
            System.out.println("getPath "+file.getPath());
            System.out.println("getAbsoluteFile "+file.getAbsoluteFile());
            System.out.println("getCanonicalFile "+file.getCanonicalFile());
            System.out.println("getClass "+file.getClass());
            System.out.println("getFreeSpace "+file.getFreeSpace());
            System.out.println("getFreeSpace "+file.getFreeSpace());
            System.out.println("getTotalSpace "+file.getTotalSpace());
            System.out.println("getUsableSpace "+file.getUsableSpace());
            
            
            
            
            //ImageIcon image=new ImageIcon(path);
            Image image = new Image(file.toURI().toString());
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
