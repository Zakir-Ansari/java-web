package org.zakir.wipro;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Here we called the servlet through configured web.xml
public class XmlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("XML servlet called");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");
		out.print("Hello from the Get method."+userName);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("XML servlet called");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");
		String fullName = request.getParameter("fullName");
		out.print(" Hello from Post method. "+userName+"\n We know your full name is: "+ userName + fullName);
		String prof = request.getParameter("prof");
		out.println(" You are a " + prof);
		//String location = request.getParameter("location"); for a single selection
		String[] location = request.getParameterValues("location");
		out.println(" You are in "+ location.length + " places ");
		for(int i=0; i<location.length; i++) {
			out.println(location[i]);
		}
	}
}
//last video: 7