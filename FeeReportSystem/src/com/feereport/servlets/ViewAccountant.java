package com.feereport.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.feereport.beans.AccountantBean;
import com.feereport.dao.AccountantDao;

/**
 * Servlet implementation class ViewAccountant
 */
@WebServlet("/ViewAccountant")
public class ViewAccountant extends HttpServlet {
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
			out.println("<title>Admin | View Accountant</title>");		
			out.println("<link rel=\"stylesheet\" href=\"css/nav-bar.css\">");
			out.println("<link rel=\"stylesheet\" href=\"css/adminhome.css\">");
			out.println("<link rel=\"stylesheet\" href=\"css/table_format.css\">");
			out.println("</head>");
			out.println("<body>");

			out.println("<nav class=\"nav-bar\">"
					+ "<ul class=\"nav navbar-nav\">\n" + 
					"		 <li><h2 class=\"brand\">FEE REPORT</h2></li>" +
					"        <li><a href=\"AdminHome\">Home</a></li>\n" + 
					"        <li><a href=\"AddAccountantForm\">Add Accountant</a></li>\n" + 
					"        <li><a href=\"#\" class=\"active\">View Accountant</a></li>\n" + 
					"        <li><a href=\"Logout\" class=\"logout\">Logout</a></li>\n" + 
					"        \n" + 
					" </ul>" +
					"<nav>");
		
			
			List<AccountantBean> list=AccountantDao.getAllRecords();
			out.println("<table class='table table-bordered table-striped'>");
			out.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Password</th><th>Address</th><th>Contact</th><th>Edit</th><th>Delete</th>");
			for(AccountantBean bean:list){
				out.print("<tr><td>"+bean.getId()+"</td><td>"+bean.getName()+"</td><td>"+bean.getEmail()+"</td><td>"+bean.getPassword()+"</td><td>"+bean.getAddress()+"</td><td>"+bean.getContact()+"</td><td><a href='EditAccountantForm?id="+bean.getId()+"'>Edit</a></td><td><a href='DeleteAccountant?id="+bean.getId()+"'>Delete</a></td></tr>");
			}
			out.println("</table>");
				
			out.println("</div>");
			request.getRequestDispatcher("footer.jsp").include(request, response);
			out.println("</body>");
			out.println("</html>");
			
			out.close();
		}
	
	}

}
