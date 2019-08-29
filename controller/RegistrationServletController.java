package com.wipro.frs.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.wipro.frs.service.*;

/**
 * Servlet implementation class RegistrationServletController
 */
@WebServlet("/RegistrationServletController")
public class RegistrationServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static{
	    try {
	        Class.forName ("oracle.jdbc.OracleDriver");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			String firstname= request.getParameter("firstname");
			String lastname= request.getParameter("lastname");
			String password= request.getParameter("password");
			String email= request.getParameter("email");
			int phone= Integer.parseInt(request.getParameter("phone"));
			RegisterPassenger rp = new RegisterPassenger();
			System.out.println((rp.Register(password, firstname, lastname, phone, email))); 
			
			response.sendRedirect("search.jsp");

		
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		
	}

}
