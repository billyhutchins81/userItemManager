package testpack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/DeleteItem")
public class DeleteItemServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession sess = request.getSession();
		User u = (User) sess.getAttribute("user");
		if(u != null) {

			int itemId = Integer.parseInt(request.getParameter("id"));
			
			
			DB_Access db = new DB_Access();
			if(db.deleteItem(itemId, u.getUid()))
				response.sendRedirect("Home");
			else
				response.sendRedirect("Home?msg=item was not deleted");
		}
		else
			response.sendRedirect("Login?msg=you have to login first");
	}
	

}

	