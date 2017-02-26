package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	static Connection con;
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		
		/*Class.forName("com.mysql.jdbc.Driver");		
	    return DriverManager.getConnection("jdbc:mysql://localhost:3306/webStore","root","root");*/
		
		Class.forName("oracle.jdbc.driver.OracleDriver");	
	    return DriverManager.getConnection("jdbc:oracle:thin:mystoreusr/mystoreusr@localhost:1521:xe"); 
	    
	      
        
	}


}
