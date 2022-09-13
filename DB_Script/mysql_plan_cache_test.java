import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.time.LocalTime;
import com.sun.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;


public class mysql_plan_cache_test {
    public static void main(String[] args) throws InterruptedException {
        Connection conn;
        Statement stmt = null;
        ResultSet rs = null, rs_explain = null;
        String sql, sql_explain = null;
        int count = 0;               
        
        // SELECT
        try {        	
        	conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306","silver","");
        	stmt = conn.createStatement();
        	//sql = "SELECT * FROM stat.test WHERE uid = 900 LIMIT 1";
        	sql = "INSERT INTO stat.test SELECT rand(), rand(), 'a', 'b'";
        	sql_explain = "EXPLAIN INSERT INTO stat.test SELECT rand(), rand(), 'a', 'b'";
        	
        	while(true) {
        		// 회차
        		count = count + 1;
        		
            	System.out.printf("%d회차\n", count);
            	
            	rs_explain = stmt.executeQuery(sql_explain);
            	
            	// explain type
            	while (rs_explain.next()) {
                    System.out.println(rs_explain.getString("type"));                    
                }
            	
        		// Start Time
            	System.out.println(LocalTime.now());
            	        
            	rs = stmt.executeQuery(sql);            	            	
            	
            	// End Time
            	System.out.println(LocalTime.now());
            	
            	// interval 0.5s
            	Thread.sleep(500);
            	
            	rs.close();
            	            	
        	}                	  	
        
        }
        catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        finally {
        	if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { } // ignore

                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore

                stmt = null;
            }
        }
        
    }
}
