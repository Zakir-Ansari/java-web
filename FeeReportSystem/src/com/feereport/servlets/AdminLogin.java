package com.feereport.servlets;

import java.io.IOException;

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
		//response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(email.equals("admin@feereport.com") && password.equals("adm!n@123")) {
			session.setAttribute("user", "valid");
			session.setMaxInactiveInterval(160);				//set 2 minutes as inactive interval
			response.sendRedirect("AdminHome");
		}

		else {
			// Setting the attribute of the request object 
		    // which will be later fetched by a JSP page 
		    request.setAttribute("error", "Invalid email or password"); 
			request.getRequestDispatcher("home.jsp").include(request, response);
		}
	}

}
