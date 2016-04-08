package testpack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/EditAccount")
public class EditUserInfoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String msg = "";
		if (request.getParameter("msg") != null)
			msg = request.getParameter("msg");

		HttpSession sess = request.getSession();
		User u = (User) sess.getAttribute("user");

		if (u == null) {
			// user login info provided is not valid, send user
			// back to the login page with the error message
			response.sendRedirect("Login?msg=Must login first");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/editaccount.jsp");
			rd.forward(request, response);

			

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sess = request.getSession();
		User u = (User) sess.getAttribute("user");
		
		String msg = "";
		if(request.getParameter("msg") != null)
			msg = request.getParameter("msg");

		if (u != null) {
			String uname = "";
			String upass = "";
			String fullname = "";
			uname = request.getParameter("uname");
			fullname = request.getParameter("fullname");
			upass = request.getParameter("upass");

			
			
			if(!uname.matches("[a-zA-Z]+$") && !fullname.matches("[a-zA-Z]+$")) {
				response.sendRedirect("Home?msg=cannot input numbers ");
			} else {
			
			u.setUserName(fullname);
				
			DB_Access db = new DB_Access();

			try {
			
				if (db.updateUserInfo(uname, fullname, upass, u.getUid()))
					response.sendRedirect("Home");
				else
					response.sendRedirect("Home?msg=user info not updated ");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
}
