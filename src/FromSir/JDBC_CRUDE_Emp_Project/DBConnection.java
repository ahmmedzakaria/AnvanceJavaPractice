/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FromSir.JDBC_CRUDE_Emp_Project;

import java.sql.*;

/**
 *
 * @author User
 */
public class DBConnection {

    public static Connection getDBConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123");
        } catch (Exception e) {
        }
        return con;
    }
}
