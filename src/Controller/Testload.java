package Controller;


/*
public class Testload {

}*/

import java.sql.*;  
//class OracleCon{  


class Testload{ 
public static void main(String args[]){  
try{  
//step1 load the driver class  
Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
Connection con = DriverManager.getConnection("jdbc:oracle:thin:mystoreusr/mystoreusr@localhost:1521:xe");  
  
//step3 create the statement object  
Statement stmt = con.createStatement();  
  
//step4 execute query  
ResultSet rs=stmt.executeQuery("SELECT * from mystore_customer");  
	
while(rs.next())  
//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
  
	 System.out.println(rs.getString(1)+"  "+rs.getString(2));
	//System.out.println(rs.get);
	
//step5 close the connection object  
con.close();  
  
}catch(Exception e){ System.out.println(e);}  
  
}  
}  
	

	
	
	
	
	
	