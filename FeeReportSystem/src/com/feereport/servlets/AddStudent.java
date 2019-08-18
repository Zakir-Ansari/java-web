package com.feereport.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.feereport.beans.StudentBean;
import com.feereport.dao.StudentDao;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int roll = Integer.parseInt(request.getParameter("roll"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String sex = request.getParameter("sex");
		String course = request.getParameter("course");
		int fee = Integer.parseInt(request.getParameter("fee"));
		int paid = Integer.parseInt(request.getParameter("paid"));
		int due=Integer.parseInt(request.getParameter("due"));
		String address=request.getParameter("address");
		String contact=request.getParameter("contact");
		
		StudentBean bean = new StudentBean(roll,name,email,sex,course,fee,paid,due,address,contact);
		int status = StudentDao.save(bean);
		
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
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
			

			out.println("<div style=\"text-align: center; font-size: 20px; margin-top: 20px;\">");
			if(status == 1)
				out.println("<h3>Student details recorded successfully!</h3>");
			else
				out.println("<h3>There is some error while processing student records!</h3>");

			out.println("<form action=\"AddAccountantForm\">\n" + 
						"    <input type=\"submit\" value=\"Add Again\" />\n" + 
						"</form>");
			out.println("</div>");
			request.getRequestDispatcher("footer.jsp").include(request, response);
			out.println("</body>");
			out.println("</html>");
		}
		out.close();
			
		
	}

}
