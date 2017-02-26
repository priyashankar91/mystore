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

/**+
 * HttpServlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		
		String resource;   // = "login.jsp";
		boolean validLogin = false;
	
		try {
			
				User user = DAO.getUser(userid);
				System.out.print("validation");
				if(user.getPassword().equals(password)) 
				{
					
					validLogin = true;
						
					
				}
				else
				{
					System.out.print("exception1");
						message = "<b>The password is not valid";
				}
		}catch (DataException e) {
		
				message = "<b>"+e.getMessage();
		}
		
		if(!validLogin) 
				resource = "login.jsp";
		else
		{	 	resource = "index.jsp";
				System.out.print("LOGGED IN");
		} 
	
	    request.setAttribute("message", message);
		RequestDispatcher dispatcher = request.getRequestDispatcher(resource);
		dispatcher.forward(request, response);
		
		
		
		
		
	}

}
