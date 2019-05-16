package com.zakir.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
@WebServlet(name = "LoginController", urlPatterns = { "/LoginController" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String un = request.getParameter("uname");
		String pw = request.getParameter("pass");
		
		if(un.equals("Zakir")) {
			out.print("Welcome, "+un);
			HttpSession session = request.getSession(true);			//reuse existing
			session.setAttribute("user", un);
			session.setMaxInactiveInterval(20); 					//maintain session for 20 sec
			response.sendRedirect("home.jsp");
		}
		else {
			//push back to login.jsp
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			out.println("<font color=red>Either user name or password is wrong </font>");
			rd.include(request, response);
		}
	}

}
