package com.feereport.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.feereport.dao.AccountantDao;

/**
 * Servlet implementation class DeleteAccountant
 */
@WebServlet("/DeleteAccountant")
public class DeleteAccountant extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		AccountantDao.delete(id);
		response.sendRedirect("ViewAccountant");
	}

}
