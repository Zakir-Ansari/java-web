package com.feereport.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.feereport.dao.AccountantDao;

/**
 * Servlet implementation class AccountantLogin
 */
@WebServlet("/AccountantLogin")
public class AccountantLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		boolean status=AccountantDao.validate(email, password);
		String accountantName = AccountantDao.getAccountantName(email, password);
		
		HttpSession session = request.getSession();
		
		if(status) {
			session.setAttribute("accountant", accountantName);
			session.setMaxInactiveInterval(160);				//set 2 minutes as inactive interval
			response.sendRedirect("AccountantHome");
		}
		else {
		    request.setAttribute("accountant_error", "Invalid email or password"); 
			request.getRequestDispatcher("home.jsp").include(request, response);
		}
	}
}
