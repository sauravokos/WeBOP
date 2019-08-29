package com.wipro.frs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wipro.frs.service.*;
/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminValidationServlet")
public class AdminValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			HttpSession session = request.getSession(); 
			String name= request.getParameter("name");
			String password= request.getParameter("password");
			Processing vc= new Processing();
			if(vc.validateAdmin(name, password))
			{
				session.setAttribute("name", name);
				response.sendRedirect("adminpage.jsp");
			}
			else
			{
				System.out.println("access denied.");
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println("Mistake @ AdminControllerServlet");
			
		}
	}

}
