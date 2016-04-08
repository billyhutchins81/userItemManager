package testpack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/EditItem")
public class EditItemServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sess = request.getSession();
		User u = (User) sess.getAttribute("user");
		int itemId = Integer.parseInt(request.getParameter("id") + "");
		sess.setAttribute("id", itemId);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/edititem.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		HttpSession sess = request.getSession();
		User u = (User) sess.getAttribute("user");
		
		String msg = "";
		if(request.getParameter("msg") != null)
			msg = request.getParameter("msg");

		if (u != null) {

			int itemId = Integer.parseInt(sess.getAttribute("id") + "");
			String itemName = request.getParameter("itemName");
			int itemQuantity = Integer.parseInt(request.getParameter("itemQty"));
			
			DB_Access db = new DB_Access();
			if (itemQuantity > 0 && db.updateItemInfo(itemName, itemQuantity, itemId, u.getUid()))
				response.sendRedirect("Home");
			else
				response.sendRedirect("Home?msg=item was not updated pls enter quantity greater than 0");
		} else
			response.sendRedirect("Login?msg=you have to login first");
	}

}
