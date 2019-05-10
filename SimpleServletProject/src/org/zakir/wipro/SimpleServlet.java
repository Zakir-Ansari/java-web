package org.zakir.wipro;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet(description = "An example for servlet", urlPatterns = { "/SimpleServlet", "/SimpleServletPath" })

//Here we called the servlet through WebServlet annotation above
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Servlet has been requested to get a response.");

		// For response, will send an html response to client side.
		PrintWriter writer = response.getWriter();
		writer.println("Below is the response:\n" + "<h3>Hellow in HTML.</h3>");
		String userName = request.getParameter("name");
		
		//In order to save user data to server memory we use Session object given by tomcat.
		HttpSession session = request.getSession();
		ServletContext context = request.getServletContext();
		if (userName != "" && userName != null) {
			session.setAttribute("savedUserName", userName);
			context.setAttribute("savedUserName", userName);
		}
		/*http://localhost:8080/SimpleServletProject/SimpleServlet?name=test
		 */
		writer.println("Request parameter has username as " + userName);
		writer.println("Session parameter has username as " + (String) session.getAttribute("savedUserName"));
		writer.println("Context parameter has username as " + (String) context.getAttribute("savedUserName"));
	}
}
/* Run this with above url, which is passing parameter for name
 * once page is loaded, request and session parameter will be loaded
 * Then, if you remove the name parameter, Session parameter will be saved for the user name
 * even if the request parameter gets null.
 * 
 * Context object: again tomcat implemented. It is applicable for the web app, totally(Any browser on any Machine).
 */
