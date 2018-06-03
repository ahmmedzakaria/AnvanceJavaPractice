package content;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BatchUpdate {

        public static void main(String[] args) {

        Connection con = null;
        Statement st = null;

        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "bari123";

        try {
          con = DriverManager.getConnection(url, user, password);

          con.setAutoCommit(false);
          st = con.createStatement();

          st.addBatch("DELETE FROM authors");
          st.addBatch("INSERT INTO authors(name) VALUES('Jamal')");
          st.addBatch("INSERT INTO authors(name) VALUES('Himel')");
          st.addBatch("INSERT INTO authors(name) VALUES('Lion')");
          st.addBatch("INSERT INTO authors(name) VALUES('Emtiaz')");
          st.addBatch("INSERT INTO authors(name) VALUES('Tipu')");
          st.addBatch("INSERT INTO authors(name) VALUES('Rashed')");

          int counts[] = st.executeBatch();
          con.commit();
          System.out.println("Committed " + counts.length + " updates");

        } catch (SQLException ex) {

            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException ex1) {
                    Logger lgr = Logger.getLogger(BatchUpdate.class.getName());
                    lgr.log(Level.WARNING, ex1.getMessage(), ex1);
                }
            }

            Logger lgr = Logger.getLogger(BatchUpdate.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } finally {

            try {
 
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(BatchUpdate.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
    }
}
