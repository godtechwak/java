import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.time.LocalTime;
import com.sun.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;


public class mysql_revoke_test {
	public static void main(String[] args)
	  {
	    try
	    {
	      // create a mysql database connection
	      
	      

	      
	      // the mysql insert statement
	      String query = " insert into stat.test(id, uid, col1, col2)"
	        + " values (?, ?, ?, ?)";

	      while(true) {
	    	  Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306", "silver", "");
		      // create the mysql insert preparedstatement
		      PreparedStatement preparedStmt = conn.prepareStatement(query);
		      preparedStmt.setDouble (1, Math.random()*100000000);
		      preparedStmt.setDouble (2, Math.random()*100000000);	     
		      preparedStmt.setString(3, "a");
		      preparedStmt.setString(4, "b");
	
		      // execute the preparedstatement
		      preparedStmt.execute();
		      
		      System.out.println("test is test");
		      Thread.sleep(10000);
		      conn.close();		      
	      }
	      	  
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(e.getMessage());
	    }
	  }
}
