package testpack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ViewItem")
public class ViewItemServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		User u = (User)sess.getAttribute("user");
		
		if(u == null) {
			//someone is trying to bypass the login page, send him back to login page
			response.sendRedirect("Login?msg=You have to Login First");
		} else {
			//valid user show the page content
			DB_Access db = new DB_Access();
			ArrayList<Item> items = db.getUserItems(u.getUid());
			request.setAttribute("items", items);
			
			int itemId = Integer.parseInt(request.getParameter("id"));
			Item i = db.getItemDetails(itemId, u.getUid());
			request.setAttribute("i",i);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/viewitem.jsp");
			rd.forward(request, response);
			
		}
	}
}




