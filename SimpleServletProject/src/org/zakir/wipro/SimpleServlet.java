package org.zakir.wipro;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet(description = "An example for servlet", urlPatterns = {
		"/SimpleServlet", "/SimpleServletPath" })

//Here we called the servlet through WebServlet annotation above
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet has been requested to get a response.");
		
		//For response, will send an html response to client side.
		PrintWriter writer = response.getWriter();
		writer.println("Below is the response:\n"+"<h3>Hellow in HTML.</h3>");
	}

}
