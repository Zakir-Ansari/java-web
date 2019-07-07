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
 * Servlet implementation class EditAccountantForm
 */
@WebServlet("/EditAccountantForm")
public class EditAccountantForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		PrintWriter out=response.getWriter();
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		AccountantBean bean=AccountantDao.getRecordById(id);
		
		
		if(session.getAttribute("user") == null || !session.getAttribute("user").equals("valid")) {
			request.setAttribute("no_user_logged_in", "true"); 
			request.getRequestDispatcher("home.jsp").include(request, response);
		}
		else {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Admin Panel</title>");		
			out.println("<link rel=\"stylesheet\" href=\"css/nav-bar.css\">");
			out.println("<link rel=\"stylesheet\" href=\"css/adminhome.css\">");
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
			out.println("<div class='container'>");
			
			out.print("<h3 style=\"text-align: center; font-size: 20px;\">Edit Accountant Form</h3>");
			out.println("<div align=\"center\" style=\"border:1px solid #555753; margin: 1% 30%;\">");
			out.print("<form action='EditAccountant' method='post' style=\"margin-top: 30px; margin-bottom: 30px;\">");
			out.print("<table>");
			out.print("<tr><td><input type='hidden' name='id' value='"+bean.getId()+"' /></td></tr>");
			out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+bean.getName()+"'/></td></tr>");
			out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+bean.getEmail()+"'/></td></tr>");
			out.print("<tr><td>Password:</td><td><input type='text' name='password' value='"+bean.getPassword()+"'/></td></tr>");
			out.print("<tr><td>Address:</td><td><textarea name='address' style='width:300px;height:100px;'>"+bean.getAddress()+"</textarea></td></tr>");
			out.print("<tr><td>Contact No:</td><td><input type='text' name='contact' value='"+bean.getContact()+"'/></td></tr>");
			out.print("<tr><td colspan='2' align='center'><input type='submit' value='Update Accountant' class='btn btn-default'/></td></tr>");
			out.print("</table>");
			out.print("</form>");
			out.println("</div>");
			request.getRequestDispatcher("footer.jsp").include(request, response);
			out.println("</body>");
			out.println("</html>");
		}
		
		out.close();
	}

}
