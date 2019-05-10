package com.serlvets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("userName");
		String pass = request.getParameter("password");
		
		//Logic to validate credentials :: can be with database also
		if(uname.equals("Zakir") && pass.equals("password")) {
			//user is valid, so redirect it to welcome
			//Whenever a user is login, set the data into a session
			//to check user authentication on every page.
			HttpSession session = request.getSession();
			session.setAttribute("userName", uname);
			
			response.sendRedirect("welcome.jsp");
		}
		else {
			response.sendRedirect("login.jsp");
		}
	}

}
