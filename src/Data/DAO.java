package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.driver.*;
import java.sql.*;

//import Model.Comment;
import Model.Product;
import Model.Transaction;
import Model.User;

public class DAO {
	public static User getUser(String userid) throws DataException {
		System.out.print("DAO_1");
		Connection con = null;
		User user = null;
		
		try {
			
			con = DBManager.getConnection();
			
		} catch (Exception e) {
			throw new DataException();
		}

		try {
			
			Statement stmt = (Statement) con.createStatement();
		
			ResultSet rs = stmt.executeQuery("select USERNAME userid, PASSWD password, CUST_NAME name, CUST_PH phoneno,CUST_EMAIL email FROM MYSTORE_V_CUSTOMER where username = '"+ userid +"'");
			
			if (rs.next()) {
				System.out.print("DAO_2");
				user = new User();
				user.setUserid(userid);
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phoneno"));
				
			} else
			{ 
				throw new InvalidUserIdException();
				
				}
			

		} catch (SQLException se) {
			throw new DataException(se.getMessage());
		}finally {
			//System.out.print("DAO_finall");
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					//System.out.print("DAO_exp");
					
					e.printStackTrace();
				}
		}

		return user;
	}

	
	public static void saveUser(User user) throws DataException {

		Connection con = null;
		try {
			con = DBManager.getConnection();
		} catch (Exception e) {
			throw new DataException();
		}

		try {
			
			String insStr = "INSERT INTO MYSTORE_CUSTOMER(USERNAME,PASSWD, CUST_NAME, CUST_PH, CUST_EMAIL) VALUES(?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(insStr);
			
			stmt.setString(1, user.getUserid());
			stmt.setString(2, user.getPassword());	
			stmt.setString(3, user.getName());	
			stmt.setString(4, user.getPhone());
			stmt.setString(5, user.getEmail());			
			

			
			int result = stmt.executeUpdate();
			
			if (result != 1) {
				throw new DataException("Failed to insert data");
			}
		

		} catch (SQLException se) {
			throw new DataException(se.getMessage());
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		}

	}
	
	public static Product getProd(int pid) throws DataException {
		Connection con = null;
		Product prod = null;
		String pname;
		int pcost;
		String pspec;
		String dateadded;
		String imgpath;
		
		try 
		{
			
			con = DBManager.getConnection();
		} catch (Exception e) 
		{
			throw new DataException();
		}

		try {
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from mystore_product where prod_id = '"+ pid +"'");
			if (rs.next()) {
				prod = new Product();
				pid=rs.getInt("pid");
				pname=rs.getString("pname");
				pcost=rs.getInt("pcost");
				pspec=rs.getString("pspec");
				dateadded=rs.getString("dateadded");
				imgpath=rs.getString("imgpath");
				
				prod.setPid(pid);
				prod.setPname(pname);
				prod.setPcost(pcost);
				prod.setPspec(pspec);
				prod.setDateadded(dateadded);
				prod.setImgpath(imgpath);

			} else
			{ throw new InvalidUserIdException();
				}
			

		} catch (SQLException se) {
			throw new DataException(se.getMessage());
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		}

		return prod;
	}
	
	
	
	public static Transaction insertTrans(String user, int totalCost) throws DataException {
		int tid=0;
		boolean Collision = true;
		Transaction t = new Transaction();
		
		Connection con = null;
		try {
			con = DBManager.getConnection();
		} catch (Exception e) {
			
			throw new DataException();
		}

		try {
			String insStr = "insert into mystore_sales values(?,?,?)";
			PreparedStatement stmt = con.prepareStatement(insStr);
			
			Statement Chkstmt = (Statement) con.createStatement();
			while(Collision == true) {
				tid = (int)(Math.random()*999999);
				ResultSet rs = Chkstmt.executeQuery("select * from mystore_sales where sales_id = '"+ tid +"'");
				if(!rs.next()) {
						Collision = false;
				}
			}
			t.setTotalcost(totalCost);
			t.setTranid(tid);
			t.setUsername(user);
			
			stmt.setInt(1,t.getTranid());
			stmt.setString(2,t.getUsername());
			stmt.setInt(3,t.getTotalcost());
			
			int result = stmt.executeUpdate();
			if (result != 1) {
				throw new DataException("Failed to insert data");
			}
		

		} catch (SQLException se) {
			//System.out.println("hi");
			throw new DataException(se.getMessage());
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		}
		System.out.println(t.getTranid());
		return t;

	}

	public static List<Product> getfurniture() {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<Product> getelectronics() {
		// TODO Auto-generated method stub
		return null;
	}

}

