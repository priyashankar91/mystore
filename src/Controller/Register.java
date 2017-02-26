package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.DAO;
import Data.DataException;
import Model.User;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		String message = null;
		//boolean validRegister = false;
		String resource = "login.jsp";
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		
		//Setting value in the User class
		User user = new User();
		user.setUserid(userid);
		user.setPassword(password);
		user.setName(name);
		user.setEmail(email);
		user.setPhone(phone);
		
		//User data to be stored in the database.......
		try {
			DAO.saveUser(user);
			//validRegister = true;
			System.out.println("INSERTED SUCCESSFULLY");

		} catch (DataException e) {
						message = e.getMessage();
						System.out.println(message);
						e.printStackTrace();

		}
		message = "Welcome! "+user.getName()+" Registered successfully, Please Login";
		
		request.setAttribute("message", message);
		RequestDispatcher dispatcher = request.getRequestDispatcher(resource);
		dispatcher.forward(request, response);

	}

}
