package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.DAO;
import Data.DataException;
import Model.Product;
import Model.ShoppingCart;

/**
 * Servlet implementation class addToCart
 */
public class addToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addToCart() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Product p = null;
		String message= null;
		String resource = "index";
		int pid = Integer.parseInt(request.getParameter("pid"));
		try {
			p = new Product();
			p = DAO.getProd(pid);
			message = p.getPname()+" added to cart";
		} catch (DataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ShoppingCart.addToCart(p);
		//ShoppingCart.printCart();
		request.setAttribute("message", message);
		RequestDispatcher dispatcher = request.getRequestDispatcher(resource);
		dispatcher.forward(request, response);
	}

}
