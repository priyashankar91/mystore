package Controller;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.DAO;
import Data.DataException;
import Model.ShoppingCart;
import Model.Transaction;

/**
 * Servlet implementation class BuyCart
 */
public class BuyCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
			  {
			    int listPrice;
			    int discount;
			    int discountPrice;
				int totalCost = Integer.parseInt(request.getParameter("totalCost"));
				String user = request.getParameter("user");
                Scanner scan = new Scanner( System.in );

			    System.out.print("Enter list price in cents: ");
			    listPrice = scan.nextInt();

			    System.out.print("Enter discount in percent: ");
			    discount = scan.nextInt();

			    discountPrice = listPrice - (listPrice*discount)/100 ;
			    System.out.println( "Discount Price: " + discountPrice );
			    Transaction t = null;
		System.out.println("TC" + totalCost);
		String resource="buyFinal.jsp";
		ShoppingCart.EmptyCart();
		try {
			t = DAO.insertTrans(user,totalCost);
		} catch (DataException e) {

			e.printStackTrace();
		}
		request.setAttribute("trans",t);
		RequestDispatcher dispatcher = request.getRequestDispatcher(resource);
		dispatcher.forward(request, response);
	}

}
