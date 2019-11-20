package gem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class LinkJavaMySQL {
    
    //JDBC URL, username and password of MySQL server
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = ""jdbc:mysql://localhost:3306/greenhouse"";
    private static final String user = "natalie";
    private static final String password = "password";
    
    //JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;
    
    public static void main(String args[]){
        
        
    }
    
    public ResultSet selectQuery(String query) {
        
        try {
            Class.forName(driver);
            //open database connection
            con = DriverManager.getConnection(url, user, password);
            
            //getting Statement object to execute query
            stmt = con.createStatement();
            
            //executing SELECT query
            rs = stmt.executeQuery(query);
            
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            //try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            //try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
        
        return rs;
    }
    
    public boolean insertQuery(String query) {
        
        boolean result = true;
        
        try {
            Class.forName(driver);
            //open database connection
            con = DriverManager.getConnection(url, user, password);
            
            //getting Statement object to execute query
            stmt = con.createStatement();
            
            //executing INSERT query
            stmt.executeUpdate(query);
            
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
            result = false;
            
        } finally {
            //try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            //try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            //try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
        
        return result;
    }
    
}
