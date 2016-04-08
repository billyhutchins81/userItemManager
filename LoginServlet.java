package testpack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/login.jsp");
		rd.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
		
		if(OurUtils.validateTextParam(uname) && OurUtils.validateTextParam(upass)) {
			// values are valid, send them to database for verification
			DB_Access db = new DB_Access();
			User u = db.validateLogin(uname, upass);
			if(u == null) {
				//user name or password are wrong, send to the login page with error message
				response.sendRedirect("Login?msg=Wrong Values, Try again");
			} else {
				//correct user info, send to the home page
				request.getSession().setAttribute("user", u);
				request.getSession().setAttribute("uname", uname);
				request.getSession().setAttribute("upass", upass);
				response.sendRedirect("Home");
				
			}
		} else {
			// values are not valid, send the user back to login page with error messenger
			response.sendRedirect("Login?msg=Wrong Values, Try again");
		}
		
	}

}
