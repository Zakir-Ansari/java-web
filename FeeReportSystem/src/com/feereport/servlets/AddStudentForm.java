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
 * Servlet implementation class AddStudentForm
 */
@WebServlet("/AddStudentForm")
public class AddStudentForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		if(session.getAttribute("accountant") == null) {
			request.setAttribute("no_user_logged_in", "true");
			request.getRequestDispatcher("home.jsp").include(request, response);
		}
		else {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Accountant | Home</title>");		
			out.println("<link rel=\"stylesheet\" href=\"css/nav-bar.css\">");
			out.println("<link rel=\"stylesheet\" href=\"css/adminhome.css\">");
			out.println("</head>");
			out.println("<body>");
	
			out.println("<nav class=\"nav-bar\">"
					+ "<ul class=\"nav navbar-nav\">\n" + 
					"		 <li><h2 class=\"brand\">FEE REPORT</h2></li>" +
					"		 <li><a href=\"AccountantHome\">Home</a></li>\n" + 
					"        <li><a href=\"#\" class=\"active\">Add Student</a></li>\n" + 
					"        <li><a href=\"ViewStudent\">View Student</a></li>\n" + 
					"        <li><a href=\"DueFee\">Due Fee</a></li>\n" + 
					"        <li><a href=\"SearchStudentForm\">Search Student</a></li>\n" + 
					"        <li><a href=\"Logout\">Logout</a></li>" +
					" </ul>" +
					"<nav>");
			request.getRequestDispatcher("AddStudentForm.jsp").include(request, response);
			request.getRequestDispatcher("footer.jsp").include(request, response);
			out.println("</body>");
			out.println("</html>");
			out.close();
		}
	}
}
