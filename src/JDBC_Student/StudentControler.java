/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC_Student;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class StudentControler {

    static Connection con;
    static Statement stmt;
    static ResultSet rs;

    public static boolean saveEmployee(String name, String address, String roll, String sclass) {
        boolean check = false;
        try {
            con = DatabaseHelper.getConnection();
            stmt = con.createStatement();
            int count = 0;
            count = stmt.executeUpdate("insert into tbl_student (name,address,roll,class) "
                    + "values('" + name + "','" + address + "','" + roll + "','" + sclass + "')");
            if (count > 0) {
                check = true;
            } else {
                check = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                con.close();
                stmt.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return check;
    }

    public static boolean updateStudent(String id, String name, String address, String roll, String sclass) {
        boolean check = false;
        try {
            con = DatabaseHelper.getConnection();
            stmt = con.createStatement();
            int count = 0;
            count = stmt.executeUpdate("update tbl_student set "
                    + "name='" + name + "',address='" + address + "',roll='" + roll + "',class='" + sclass + "' "
                    + "where id='" + id + "'");
            if (count > 0) {
                check = true;
            } else {
                check = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                con.close();
                stmt.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return check;
    }

    public static boolean deleteStudent(String id) {
        boolean check = false;
        try {
            con = DatabaseHelper.getConnection();
            stmt = con.createStatement();
            int count = 0;
            count = stmt.executeUpdate("delete from tbl_student where id='" + id + "'");
            if (count > 0) {
                check = true;
            } else {
                check = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                con.close();
                stmt.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return check;
    }

    public static ArrayList showStudent(String id) {
        ArrayList list = new ArrayList();
        try {
            con = DatabaseHelper.getConnection();
            stmt = con.createStatement();
            int count = 0;
            rs = stmt.executeQuery("select name,address,roll,class from tbl_student where id='" + id + "'");
            
            while (rs.next()) {
                list.add(rs.next());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                rs.close();
                con.close();
                stmt.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return list;
    }

}
