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
 * Servlet implementation class AddAccountantForm
 */
@WebServlet("/AddAccountantForm")
public class AddAccountantForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		if(session.getAttribute("user") == null || !session.getAttribute("user").equals("valid")) {
			request.setAttribute("no_user_logged_in", "true"); 
			request.getRequestDispatcher("home.jsp").include(request, response);
		}
		else {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Admin | Add Accountant</title>");		
			out.println("<link rel=\"stylesheet\" href=\"css/nav-bar.css\">");
			out.println("<link rel=\"stylesheet\" href=\"css/adminhome.css\">");
			out.println("</head>");
			out.println("<body>");
	
			out.println("<nav class=\"nav-bar\">"
					+ "<ul class=\"nav navbar-nav\">\n" + 
					"		 <li><h2 class=\"brand\">FEE REPORT</h2></li>" +
					"        <li><a href=\"AdminHome\">Home</a></li>\n" + 
					"        <li><a href=\"AddAccountantForm\" class=\"active\">Add Accountant</a></li>\n" + 
					"        <li><a href=\"ViewAccountant\">View Accountant</a></li>\n" + 
					"        <li><a href=\"Logout\" class=\"logout\">Logout</a></li>\n" + 
					"        \n" + 
					" </ul>" +
					"<nav>");
			
			out.println("<h3 style=\"text-align: center; font-size: 20px;\">Add Accountant Form</h3>");
			out.println("<div class=\"addAccountantForm\" align=\"center\" style=\"border:1px solid #555753; margin: 1% 30%;\">");
			request.getRequestDispatcher("addAccountantForm.jsp").include(request, response);
			out.println("</div>");
			request.getRequestDispatcher("footer.jsp").include(request, response);
			out.println("</body>");
			out.println("</html>");
		}
		
	}

}
