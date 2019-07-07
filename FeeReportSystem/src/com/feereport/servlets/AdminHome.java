package com.feereport.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminHome
 */
@WebServlet("/AdminHome")
public class AdminHome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		if(session.getAttribute("user") == null || !session.getAttribute("user").equals("valid")) {
			response.sendRedirect("home.jsp");
		}
		else {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Admin | Home</title>");		
			out.println("<link rel=\"stylesheet\" href=\"css/nav-bar.css\">");
			out.println("<link rel=\"stylesheet\" href=\"css/adminhome.css\">");
			out.println("</head>");
			out.println("<body>");

			out.println("<nav class=\"nav-bar\">"
					+ "<ul class=\"nav navbar-nav\">\n" + 
					"		 <li><h2 class=\"brand\">FEE REPORT</h2></li>" +
					"        <li><a href=\"#\" class=\"active\">Home</a></li>\n" + 
					"        <li><a href=\"AddAccountantForm\">Add Accountant</a></li>\n" + 
					"        <li><a href=\"ViewAccountant\">View Accountant</a></li>\n" + 
					"        <li><a href=\"Logout\" class=\"logout\">Logout</a></li>\n" + 
					"        \n" + 
					" </ul>" +
					"<nav>");
			
			request.getRequestDispatcher("adminhome.jsp").include(request, response);
			request.getRequestDispatcher("footer.jsp").include(request, response);
			out.println("</body>");
			out.println("</html>");
			
			out.close();

		}
	}

}
