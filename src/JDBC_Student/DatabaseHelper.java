/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC_Student;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author B5
 */
public class DatabaseHelper {

    public static Connection getConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_mes_2", "root", "123");
        } catch (Exception e) {
           e.printStackTrace();
        }
        return con;  
    }
    
}
