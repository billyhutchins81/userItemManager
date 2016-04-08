package testpack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CreateAccount")
public class CreateAccountServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/createAccount-form.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String loginName = "", fullName = "", userPass = "";
		boolean canCreate = true;
		if (validateInputText(request.getParameter("loginname")))
			loginName = request.getParameter("loginname");
		else
			canCreate = false;
		if (validateInputText(request.getParameter("fullname")))
			fullName = request.getParameter("fullname");
		else
			canCreate = false;
		if (validateInputText(request.getParameter("pass")))
			userPass = request.getParameter("pass");
		else
			canCreate = false;

		if(canCreate) {
			// send values to the database to be inserted
			DB_Access db = new DB_Access();
			boolean success  = db.createAccount(loginName, fullName, userPass);
			if(success) response.sendRedirect("Login?error=account successfully created");
			else response.sendRedirect("CreateAccount?error=duplicate login name, please correct");
		}
		else {
			// redisplay the form with the error message
			response.sendRedirect("CreateAccount?error=wrong values, try again");
		}
	}
	
	private boolean validateInputText(String text) {
		boolean valid = true;
		if(text.trim().equals("")) valid = false;
		return valid;
	}
}

	