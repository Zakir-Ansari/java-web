package com.feereport.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.feereport.beans.AccountantBean;
import com.feereport.dao.AccountantDao;

/**
 * Servlet implementation class AddAccountant
 */
@WebServlet("/AddAccountant")
public class AddAccountant extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			int id = AccountantDao.getNextId();
			String name=request.getParameter("name");
		 	String email=request.getParameter("email");
			String password=request.getParameter("password");
			String address=request.getParameter("address");
			String contact=request.getParameter("contact");
			
			AccountantBean bean = new AccountantBean(id,name, email, password, address, contact);
			int status=AccountantDao.save(bean);
			
			out.println("<div style=\"text-align: center; font-size: 20px; margin-top: 20px;\">");
			if(status == 1)
				out.println("<h3>Accountant is added successfully!</h3>");
			else
				out.println("<h3>There is some error while adding accountant!</h3>");

			out.println("<form action=\"AddAccountantForm\">\n" + 
						"    <input type=\"submit\" value=\"Add Again\" />\n" + 
						"</form>");
			out.println("</div>");
			request.getRequestDispatcher("footer.jsp").include(request, response);
			out.println("</body>");
			out.println("</html>");
		}
	}

}
