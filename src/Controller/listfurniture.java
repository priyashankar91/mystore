package Controller;

import java.io.IOException;
import java.util.Scanner;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.DAO;
import Data.DataException;
import Model.Product;


/**
 * Servlet implementation class listfurniture
 */
public class listfurniture extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listfurniture() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Product> ProdList = null;
		ProdList = DAO.getfurniture();
	
	request.setAttribute("ProdList", ProdList);
	RequestDispatcher dispatcher = request.getRequestDispatcher("furniture.jsp");
	dispatcher.forward(request, response);
	}

	/**	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

  public static void main ( String[] args ) 
  {
    int listPrice;
    int discount;
    int discountPrice;

    @SuppressWarnings("resource")
	Scanner scan = new Scanner( System.in );

    System.err.print("Enter list price in cents: ");      
    listPrice = scan.nextInt();
    System.out.println("Price in cents: " + listPrice );

    System.err.print("Enter discount in percent: ");      
    discount = scan.nextInt();
    System.out.println("Discount: " + discount );         
    discountPrice = listPrice - (listPrice*discount)/100 ;

    System.out.println( "Discount Price: " + discountPrice ); 
    System.err.println( "Discount Price: " + discountPrice );  
  }
}