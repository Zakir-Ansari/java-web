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
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if(email.equals("admin@feereport.com") && password.equals("adm!n@123")) {
			
			session.setAttribute("user", "valid");
			session.setMaxInactiveInterval(160);				//set 2 minutes as inactive interval
			
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
					"        <li><a href=\"LogoutAdmin\" class=\"logout\">Logout</a></li>\n" + 
					"        \n" + 
					" </ul>" +
					"<nav>");
			
			request.getRequestDispatcher("adminhome.jsp").include(request, response);
			request.getRequestDispatcher("footer.jsp").include(request, response);
			out.println("</body>");
			out.println("</html>");
			
			out.close();
		}
		else {
			// Setting the attribute of the request object 
		    // which will be later fetched by a JSP page 
		    request.setAttribute("error", "Invalid email or password"); 
			request.getRequestDispatcher("home.jsp").include(request, response);
		}
		out.close();
	}

}
