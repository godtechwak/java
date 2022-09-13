import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class mysql_packet_test {
    public static void main(String[] args) {
        Connection conn;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = null;
        
        // SELECT
        try {
        	conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306","root","");
        	stmt = conn.createStatement();
        	sql = "select concat((select concat((select concat((select concat((select concat((select concat((select concat((select concat((select concat((select concat((select concat((select concat((select concat((select concat((select concat((select concat((select concat((select concat((select concat((select concat((select concat((select concat((select concat((select concat((select concat((select concat((select concat((select concat((select concat((select concat((select concat((select concat((select test from packet_test limit 1), test) from packet_test limit 1), concat((select concat((select concat((select concat((select test from packet_test limit 1), test) from packet_test limit 1), test) from packet_test limit 1), test) from packet_test limit 1), test) ) from packet_test limit 1), test) from packet_test limit 1), test) from packet_test limit 1), test) from packet_test limit 1), concat((select concat((select concat((select concat((select test from packet_test limit 1), test) from packet_test limit 1), test) from packet_test limit 1), test) from packet_test limit 1), test) ) from packet_test limit 1), test) from packet_test limit 1), test) from packet_test limit 1), test) from packet_test limit 1), concat((select concat((select concat((select concat((select test from packet_test limit 1), test) from packet_test limit 1), test) from packet_test limit 1), test) from packet_test limit 1), test) ) from packet_test limit 1), test) from packet_test limit 1), test) from packet_test limit 1), test) from packet_test limit 1), concat((select concat((select concat((select concat((select test from packet_test limit 1), test) from packet_test limit 1), test) from packet_test limit 1), test) from packet_test limit 1), test) ) from packet_test limit 1), test) from packet_test limit 1), test) from packet_test limit 1), test) from packet_test limit 1), concat((select concat((select concat((select concat((select test from packet_test limit 1), test) from packet_test limit 1), test) from packet_test limit 1), test) from packet_test limit 1), test) ) from packet_test limit 1), test) from packet_test limit 1), test) from packet_test limit 1), test) from packet_test limit 1), concat((select concat((select concat((select concat((select test from packet_test limit 1), test) from packet_test limit 1), test) from packet_test limit 1), test) from packet_test limit 1), test) ) from packet_test limit 1), test) from packet_test limit 1), test) from packet_test limit 1), test) from packet_test limit 1), concat((select concat((select concat((select concat((select test from packet_test limit 1), test) from packet_test limit 1), test) from packet_test limit 1), test) from packet_test limit 1), test) ) from packet_test limit 1), test) from packet_test limit 1), test) from packet_test limit 1), test) from packet_test limit 1), concat((select concat((select concat((select concat((select test from packet_test limit 1), test) from packet_test limit 1), test) from packet_test limit 1), test) from packet_test limit 1), test) ) from packet_test limit 1), test) from packet_test limit 1), test) AS 'json_column' from packet_test";
        	rs = stmt.executeQuery(sql);
        	while (rs.next()) {
                System.out.println(rs.getString("json_column"));                    
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
