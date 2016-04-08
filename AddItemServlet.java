package testpack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AddItem")
public class AddItemServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/additem.jsp");
		rd.forward(request, response);
		
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		User u = (User) sess.getAttribute("user");
		if(u != null) {
			String itemName = request.getParameter("itemName");
			int itemQty = Integer.parseInt(request.getParameter("itemQty"));
			int userId = Integer.parseInt(request.getParameter("userId"));
			
			DB_Access db = new DB_Access();
			if(db.addNewItem(itemName, itemQty, userId))
				response.sendRedirect("Home");
			else
				response.sendRedirect("Home?error=item was not added");
		}
		else
			response.sendRedirect("Login?error=you have to login first");
	}
}
