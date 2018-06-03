/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batchInsert;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zakakaria
 */
public class AccountDbController {
    
    public static void main(String[] args) {
        System.out.println("lsd");
        System.out.println(getTotalBazar("7"));
    }

    static Connection con = null;
    static Statement st  = null;
    static CallableStatement csmt = null;

     public static double getTotalBazar(String accountId) {
        double ttlBazar= 0;
        try {
            con = DatabaseHelper.getConnection();
            csmt = con.prepareCall("{?=CALL fgetTotalBazar(?)}");
            csmt.registerOutParameter(1, java.sql.Types.INTEGER);
            csmt.setString(2, accountId);   
            csmt.execute();
            ttlBazar=csmt.getDouble(1);;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            
        }
        return ttlBazar;
    }

}
