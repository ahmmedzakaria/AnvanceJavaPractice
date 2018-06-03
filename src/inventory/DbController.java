/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Zakakaria
 */
public class DbController {
    static Connection con=null;
    static Statement st=null;
    static ResultSet rs=null;
    
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
              Connection con = DriverManager.getConnection
                      ("jdbc:mysql://localhost:3306/test",
                      "root","123");
              return con;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    return con;
    }
    //insert into incentory  values(1,'Monitor',8000,10000,4,'2018-01-01')
    
    public static void purchaseProduct(Product p){
        String insert="insert into inventory (name,ppur,psel,qty,pdate) values('"+p.pName+"','"+p.pPur+"','"+p.pSale+"','"+p.pQty+"','"+p.pDate+"')";
        try {
            boolean t=true;
            con=getConnection();
            //System.out.println(con);
            st=con.createStatement();
            st.executeUpdate(insert);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    }
    
     public static void updateQty(Product p){
         String update="update inventory set qty='"+p.pQty+"' where id='"+p.pId+"'";
         System.out.println(update);
        try {
            boolean t=true;
            con=getConnection();
            //System.out.println(con);
            st=con.createStatement();
            st.executeUpdate(update);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    }
    
    
    public static List<String> getAllProductName(){
        String select="select name from  inventory";
        List<String> nameList=new ArrayList();
        try {
            boolean t=true;
            con=getConnection();
            //System.out.println(con);
            st=con.createStatement();
            st.executeQuery(select);
            rs=st.getResultSet();
            
            while (rs.next()){
                 nameList.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    return nameList;
    }
    
    public static List<Product> getAllProduct(){
        String select="select * from  inventory";
        List<Product> pList=new ArrayList();
        try {
            boolean t=true;
            con=getConnection();
            //System.out.println(con);
            st=con.createStatement();
            st.executeQuery(select);
            rs=st.getResultSet();
            
            while (rs.next()){
                Product product=new Product();
                 product.pId=rs.getString(1);
                 product.pName=rs.getString(2);
                 product.pPur=rs.getString(3);
                 product.pSale=rs.getString(4);
                 product.pQty=rs.getString(5);
                 product.pDate=rs.getString(6);
                 pList.add(product);                 
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    return pList;
    }
    
    
    
}
